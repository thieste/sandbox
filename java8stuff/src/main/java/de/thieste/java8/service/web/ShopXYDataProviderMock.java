package de.thieste.java8.service.web;

import de.thieste.java8.service.web.bean.OfferXY;
import de.thieste.java8.service.web.bean.OfferXYDataBuilder;
import de.thieste.java8.util.Util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by thieste on 21.12.15.
 */
public class ShopXYDataProviderMock {

    public List<OfferXY> getUpdatedOffers(int number) {
        Util.delay(100L);
        return IntStream
                .range(0, number)
                .mapToObj(this::createRandomOfferXY)
                .collect(Collectors.toList());
    }


    private final OfferXY createRandomOfferXY(int index) {
        return OfferXYDataBuilder
                .id("id" + index)
                .price(new Random().nextDouble())
                .title("title" + index)
                .build();
    }


}
