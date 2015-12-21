package de.thieste.java8.bean;

/**
 * Created by thieste on 21.12.15.
 */
public final class OfferBuilder {

    private Long id;

    private String title;

    private Integer price;

    private OfferBuilder(Long id) {
        this.id = id;
    }


    public static OfferBuilder id(Long id) {
        return new OfferBuilder(id);
    }

    public OfferBuilder title(String title) {
        this.title = title;
        return this;
    }

    public OfferBuilder price(Integer centValue) {
        this.price = centValue;
        return this;
    }

    public Offer build() {
        final Offer offer = new Offer();
        offer.setId(id);
        offer.setPrice(price);
        offer.setTitle(title);
        return offer;
    }
}
