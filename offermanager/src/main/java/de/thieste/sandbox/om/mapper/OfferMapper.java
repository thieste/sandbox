package de.thieste.sandbox.om.mapper;

import de.thieste.sandbox.core.bean.Offer;
import de.thieste.sandbox.om.ext.api.fia.bean.FiaOffer;
import de.thieste.sandbox.om.ext.api.gmi.bean.GmiOffer;

/**
 * Created by thieste on 22.12.15.
 */
public interface OfferMapper {

    void mapData(Offer offer, FiaOffer fiaOffer);

    void mapData(Offer offer, GmiOffer gmiOffer);

}
