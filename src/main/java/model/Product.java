package model;

public class Product {
    private String description;
    private String name;
    private double price;
    private int stock;

    public Product(){

    }

    public Product(String description, String name, double price, int stock) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
