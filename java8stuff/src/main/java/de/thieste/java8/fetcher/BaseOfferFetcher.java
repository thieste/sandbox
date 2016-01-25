package de.thieste.java8.fetcher;


import de.thieste.java8.service.db.DBService;
import de.thieste.java8.service.db.DBServiceMock;
import de.thieste.java8.service.web.ShopXYDataProviderMock;
import de.thieste.java8.service.web.bean.OfferXY;

import de.thieste.sandbox.core.bean.Offer;
import de.thieste.sandbox.core.bean.OfferBuilder;
import de.thieste.sandbox.core.util.Util;

import java.util.Random;

/**
 * Created by thieste on 21.12.15.
 */
public class BaseOfferFetcher {

    private final Random rnd = new Random();
    protected final ShopXYDataProviderMock shopXYService = new ShopXYDataProviderMock();
    protected final DBService dbService = new DBServiceMock();


    protected BaseOfferFetcher() {

    }


    protected Offer createOffer(OfferXY offerXY) {
        return OfferBuilder
                .id(rnd.nextLong())
                .title(offerXY.getTitle())
                .price(Util.toCentValue(offerXY.getPrice()))
                .build();
    }

}
