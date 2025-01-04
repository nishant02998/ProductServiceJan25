package dev.nishant.productservicejan25.models;

public class product {

    private int id;
    private String title;
    private String description;
    private double price;
    private category category;
    private String imageUrl;

    public product() {
    }

    public product(int id, String title, String description, double price, dev.nishant.productservicejan25.models.category category, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public dev.nishant.productservicejan25.models.category getCategory() {
        return category;
    }

    public void setCategory(dev.nishant.productservicejan25.models.category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
