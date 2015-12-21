package de.thieste.java8.bean;

/**
 * simple offer pojo
 * Created by thieste on 21.12.15.
 */
public class Offer {


    private Long id;

    private String title;

    private Integer price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
