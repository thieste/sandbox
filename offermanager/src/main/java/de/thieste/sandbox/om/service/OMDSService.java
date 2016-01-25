package de.thieste.sandbox.om.service;

import de.thieste.sandbox.om.bean.OfferMetaData;

/**
 * Created by thieste on 24.01.16.
 */
public interface OMDSService {
    void save(OfferMetaData offerMetaData, String filterReason);

     void save(OfferMetaData offerMetaData);
}
