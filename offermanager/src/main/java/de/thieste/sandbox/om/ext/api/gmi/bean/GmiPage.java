package de.thieste.sandbox.om.ext.api.gmi.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thieste on 22.12.15.
 */
@Getter
@Setter
public class GmiPage {

    private final List<GmiOffer> gmiOffers = new ArrayList<>();

    private Long itemCountOverall;

    public long getItemCount() {
        return gmiOffers.size();
    }


    public void addItem(GmiOffer gmiOffer){
        gmiOffers.add(gmiOffer);
    }
}
