package de.thieste.java8.fetcher;



import de.thieste.sandbox.core.bean.Offer;

import java.util.List;

/**
 * Created by thieste on 21.12.15.
 */
public interface OfferFetcher {

    List<Offer> fetch(int maxNumber);
}
