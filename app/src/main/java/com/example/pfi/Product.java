package com.example.pfi;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Product {
    private String name;
    private String seller;
    private String description;
    private int imageId;
    private double price;
    private int stock;

    public String getName() {
        return name;
    }

    public String getSeller() {
        return seller;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Product(String name, String seller, String description, int imageId, double price, int stock) {
        this.name = name;
        this.seller = seller;
        this.description = description;
        this.imageId = imageId;
        if (price <= 0)
            this.price = 19.99;
        else
            this.price = price;
        if (stock < 0)
            this.stock = 0;
        else
            this.stock = stock;
    }

    public void buyProduct(int amount) {
        stock = stock - amount;
    }
}
