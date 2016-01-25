package de.thieste.sandbox.om.bean;

/**
 * Created by thieste on 24.01.16.
 */
public class OfferMetaDataBuilder {


    private final OfferMetaData offerMetaData;

    public OfferMetaDataBuilder(OfferMetaData offerMetaData) {
        this.offerMetaData = offerMetaData;
    }

    public static OfferMetaDataBuilder offerKey(String offerKey) {
        return new OfferMetaDataBuilder(new OfferMetaData(offerKey));
    }


    public OfferMetaDataBuilder importId(String importId) {
        offerMetaData.setImportId(importId);
        return this;
    }

    public OfferMetaDataBuilder uniqueKey(String uniqueKey) {
        offerMetaData.setUniqueKey(uniqueKey);
        return this;
    }

    public OfferMetaDataBuilder filterReason(String filterReason) {
        offerMetaData.setFilterReason(filterReason);
        return this;
    }

    public OfferMetaDataBuilder price(int price) {
        offerMetaData.setPrice(price);
        return this;
    }

    public OfferMetaData build() {
        return offerMetaData;
    }
}
