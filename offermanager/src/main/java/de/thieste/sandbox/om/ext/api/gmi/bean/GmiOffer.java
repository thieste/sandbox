package de.thieste.sandbox.om.ext.api.gmi.bean;

import lombok.Data;

/**
 * Created by thieste on 22.12.15.
 */
@Data
public class GmiOffer {


    private Long id;

    private String title;

    private Condition condition;

    private Double price;


    public static enum Condition {
        NEW, USED, REBUILD
    }

}
