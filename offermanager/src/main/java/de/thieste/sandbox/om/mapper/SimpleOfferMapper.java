package de.thieste.sandbox.om.mapper;

import de.thieste.sandbox.core.bean.Offer;
import de.thieste.sandbox.core.util.Util;
import de.thieste.sandbox.om.ext.api.fia.bean.FiaOffer;
import de.thieste.sandbox.om.ext.api.gmi.bean.GmiOffer;

/**
 * Created by thieste on 22.12.15.
 */
public class SimpleOfferMapper implements OfferMapper {
    @Override
    public void mapData(Offer offer, FiaOffer fiaOffer) {
        offer.setId(fiaOffer.getId());
        offer.setTitle(fiaOffer.getTitle());
        offer.setPrice(Util.toCentValue(fiaOffer.getPrice()));
    }

    @Override
    public void mapData(Offer offer, GmiOffer gmiOffer) {
    }
}
