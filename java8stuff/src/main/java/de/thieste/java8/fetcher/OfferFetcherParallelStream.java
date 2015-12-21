package de.thieste.java8.fetcher;

import de.thieste.java8.bean.Offer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thieste on 21.12.15.
 */
public class OfferFetcherParallelStream extends BaseOfferFetcher implements OfferFetcher {
    @Override
    public List<Offer> fetch(int maxNumber) {
        return shopXYService.getUpdatedOffers(maxNumber)
                .parallelStream()
                .map(this::createOffer)
                .map(offer -> dbService.save(offer))
                .collect(Collectors.toList());
    }
}
