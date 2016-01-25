package de.thieste.java8.service.db;


import de.thieste.sandbox.core.bean.Offer;

import static de.thieste.sandbox.core.util.Util.delay;

/**
 * Created by thieste on 21.12.15.
 */
public class DBServiceMock implements DBService {

    public Offer save(Offer offer) {
        delay(1000L);
        return offer;
    }
}
