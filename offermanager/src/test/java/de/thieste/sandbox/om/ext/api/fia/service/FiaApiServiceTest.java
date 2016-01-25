package de.thieste.sandbox.om.ext.api.fia.service;

import de.thieste.sandbox.om.ext.api.fia.bean.FiaOffer;
import de.thieste.sandbox.om.ext.api.fia.bean.FiaPage;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by thieste on 22.12.15.
 */
public class FiaApiServiceTest {


    private FiaApiService fiaApiService;

    @Before
    public void setUp() throws Exception {
        fiaApiService = new FiaApiService(Arrays
                .stream(new Integer[]{0, 1, 2, 3, 4, 5})
                .map(this::createFiaPage)
                .collect(Collectors.toList()));

    }

    @Test
    public void test() {
        final Optional<FiaPage> page = fiaApiService.getNextPage(0);
        assertNotNull(page);
        assertEquals(100, page.get().itemCount());
    }


    @Test
    public void testNull() {
        final Optional<FiaPage> page = fiaApiService.getNextPage(10);
        assertNotNull(page);
        assertFalse(page.isPresent());
    }

    private FiaPage createFiaPage(Integer pageNumber) {
        final FiaPage fiaPage = new FiaPage();

        fiaPage.setPageNumber(pageNumber);
        fiaPage.setItemCountOverall(10000L);

        LongStream
                .range(0, 100)
                .forEach(n -> fiaPage.addItem(createFiaOffer(n)));
        return fiaPage;
    }


    @Test
    public void testxy(){
         IntStream
                 .range(0, 100)
                .mapToObj(i -> fiaApiService.getNextPage(i))
                .map(o ->
                        CompletableFuture.supplyAsync(
                                () -> o.get().getFiaOffers())
                );


//        fiaApiService.getNextPage()
    }


    private FiaOffer createFiaOffer(long index) {
        final FiaOffer fiaOffer = new FiaOffer();
        fiaOffer.setTitle("title");
        fiaOffer.setId(index);
        fiaOffer.setEndTime(new Date());
        fiaOffer.setQuantity(new Random().nextInt(20));
        return fiaOffer;
    }

}