package de.thieste.java8.service.db;

import de.thieste.java8.bean.Offer;
import de.thieste.java8.util.Util;

/**
 * Created by thieste on 21.12.15.
 */
public class DBServiceMock implements DBService {


    public Offer save(Offer offer) {
        Util.delay(1000L);
        return offer;
    }
}
