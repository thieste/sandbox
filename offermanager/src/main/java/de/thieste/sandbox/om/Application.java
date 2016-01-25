package de.thieste.sandbox.om;

import de.thieste.sandbox.om.bean.OfferMetaDataBuilder;
import de.thieste.sandbox.om.service.OMDSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * Created by thieste on 22.12.15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private OMDSService omdsService;

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {


        final Random priceRnd = new Random();


        final String importId = UUID.randomUUID().toString();

        LOG.info("current import {}", importId);
        final StopWatch stopWatch = new StopWatch();

        omdsService.removeOlderImports(importId);
        stopWatch.start();
        IntStream.range(0, 100000).mapToObj(i -> OfferMetaDataBuilder
                .offerKey("key" + i)
                .importId(importId)
                .price(priceRnd.nextInt(100 - 1 + 1) + 1)
                .uniqueKey("sku")
                .build()).forEach(o -> omdsService.save(o, "BEST_ITEM_FILTER"));
        stopWatch.stop();


        omdsService.save(
                OfferMetaDataBuilder
                        .offerKey("key" + 22)
                        .importId(importId)
                        .price(0)
                        .filterReason("BLACKLISTED")
                        .uniqueKey("sku")
                        .build()
        );


        LOG.info("processing time {} in s", stopWatch.getTotalTimeSeconds());
    }
}
