package de.thieste.sandbox.om.ext.api.fia.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thieste on 22.12.15.
 */
@Getter
@Setter
public class FiaPage {

    private final List<FiaOffer> fiaOffers = new ArrayList<>();

    private Long itemCountOverall;

    private Integer pageNumber;

    public long itemCount() {
        return fiaOffers.size();
    }

    public void addItem(FiaOffer fiaOffer) {
        fiaOffers.add(fiaOffer);
    }
}
