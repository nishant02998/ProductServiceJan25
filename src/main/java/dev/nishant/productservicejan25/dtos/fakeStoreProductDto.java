package dev.nishant.productservicejan25.dtos;

import dev.nishant.productservicejan25.models.category;
import dev.nishant.productservicejan25.models.product;


public class fakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public product toProduct() {
        product product = new product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        category category1 = new category();
        category1.setTitle(category);
        product.setCategory(category1);
        product.setImageUrl(image);
        return product;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
