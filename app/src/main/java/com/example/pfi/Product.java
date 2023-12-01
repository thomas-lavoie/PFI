package com.example.pfi;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Product {
    private String Name;
    private String Seller;
    private String Description;
    private int ImageId;
    private double Price;
    private int Stock;

    public String getName() {
        return Name;
    }

    public String getSeller() {
        return Seller;
    }

    public String getDescription() {
        return Description;
    }

    public int getImageId() {
        return ImageId;
    }

    public double getPrice() {
        return Price;
    }

    public int getStock() {
        return Stock;
    }

    public Product(String name, String seller, String description, int imageId, double price, int stock) {
        Name = name;
        Seller = seller;
        Description = description;
        ImageId = imageId;
        if (price <= 0)
            Price = 19.99;
        else
            Price = price;
        if (stock < 0)
            Stock = 0;
        else
            Stock = stock;
    }

    public void buyProduct(int amount) {
        Stock -= amount;
    }
}
