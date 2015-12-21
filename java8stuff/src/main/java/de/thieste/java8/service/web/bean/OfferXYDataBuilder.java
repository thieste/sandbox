package de.thieste.java8.service.web.bean;

/**
 * Created by thieste on 21.12.15.
 */
public final class OfferXYDataBuilder {

    private String id;

    private String title;
    private Double price;

    private OfferXYDataBuilder(String id) {
        this.id = id;
    }


    public static OfferXYDataBuilder id(String id) {
        return new OfferXYDataBuilder(id);
    }


    public OfferXYDataBuilder title(String title) {
        this.title = title;
        return this;
    }


    public OfferXYDataBuilder price(Double price) {
        this.price = price;
        return this;
    }


    public OfferXY build() {
        final OfferXY offerXY = new OfferXY();
        offerXY.setTitle(title);
        offerXY.setId(id);
        offerXY.setPrice(price);
        return offerXY;
    }


}
