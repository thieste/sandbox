package de.thieste.sandbox.om.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by thieste on 24.01.16.
 */
@Getter
@Setter
@Document
@CompoundIndex(name = "compound_index", def = "{'importId': 1, 'uniqueKey': 1}")
public class OfferMetaData {

    @Id
    private String offerKey;

    private String importId;

    private Integer price;

    @Indexed
    private String uniqueKey;

    private String filterReason;


    public OfferMetaData() {
    }

    public OfferMetaData(String offerKey) {
        this.offerKey=offerKey;
    }

}
