package de.thieste.sandbox.om.repository;


import de.thieste.sandbox.om.bean.OfferMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface OMDSRepository extends MongoRepository<OfferMetaData, String> {

    OfferMetaData findByOfferKey(String offerKey);

    Stream<OfferMetaData> findByUniqueKey(String uniqueKey);



}