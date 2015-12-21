package de.thieste.java8.service;

import de.thieste.java8.fetcher.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by thieste on 21.12.15.
 */

@RunWith(Parameterized.class)
public class ApplicationTest {

    private static final int MAX_NUMBER = 10;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new OfferFetcherOldSytle()
                },
                {
                        new OfferFetcherSerialStream()
                },
                {
                        new OfferFetcherParallelStream()
                },
                {
                        new OfferFetcherCompletableFuture()
                }
        });
    }


    private final OfferFetcher offerFetcher;

    public ApplicationTest(OfferFetcher offerFetcher) {
        this.offerFetcher = offerFetcher;
    }

    @Test
    public void test() {
        final long startTime = System.currentTimeMillis();

        offerFetcher.fetch(MAX_NUMBER);

        System.out.printf("fetching %d offer(s) using %s, took: %d ms",
                MAX_NUMBER,
                offerFetcher.getClass().getSimpleName(),
                (System.currentTimeMillis() - startTime));
    }
}
