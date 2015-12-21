package de.thieste.java8.fetcher;

import de.thieste.java8.bean.Offer;
import de.thieste.java8.service.web.bean.OfferXY;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thieste on 21.12.15.
 */
public class OfferFetcherOldSytle extends BaseOfferFetcher implements OfferFetcher {

    @Override
    public List<Offer> fetch(int maxNumber) {

        final List<Offer> offers = new ArrayList<>();
        for (OfferXY offerXY : shopXYService.getUpdatedOffers(maxNumber)) {
            dbService.save(createOffer(offerXY));
        }

        return offers;
    }

}
