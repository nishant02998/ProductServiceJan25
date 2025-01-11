package dev.nishant.productservicejan25.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class category extends baseModel {
    private String title;
    //already mentioned in product table
    //duplicate
    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    private List<product> products;

    public category() {
    }

    public category(String title, List<product> products) {
        this.title = title;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }
}
