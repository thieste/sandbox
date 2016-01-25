package de.thieste.sandbox.om.ext.api.fia.bean;

import lombok.Data;

import java.util.Date;

/**
 * Created by thieste on 22.12.15.
 */
@Data
public class FiaOffer {


    private Long id;

    private String title;

    private Double price;

    private Integer quantity;

    private Date endTime;



}
