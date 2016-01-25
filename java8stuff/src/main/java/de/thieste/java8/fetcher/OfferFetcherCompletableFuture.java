package de.thieste.java8.fetcher;



import de.thieste.sandbox.core.bean.Offer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by thieste on 21.12.15.
 */
public class OfferFetcherCompletableFuture extends BaseOfferFetcher implements OfferFetcher {

    private ExecutorService executorService;

    @Override
    public List<Offer> fetch(int maxNumber) {
        executorService = Executors.newFixedThreadPool(Math.min(maxNumber, 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        List<CompletableFuture<Offer>> futures = shopXYService.getUpdatedOffers(maxNumber)
                .stream()
                .map(offerXY ->
                        CompletableFuture.supplyAsync(() -> createOffer(offerXY), executorService))
                .map(f -> f.thenComposeAsync(o ->
                        CompletableFuture.supplyAsync(() -> dbService.save(o),executorService)))
                .collect(Collectors.toList());

        return futures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
