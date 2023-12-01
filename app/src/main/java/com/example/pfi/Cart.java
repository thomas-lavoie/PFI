package com.example.pfi;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Product> cart = new ArrayList<>();

    public static List<Product> getCart() {
        return cart;
    }

    public static int count() {
        return cart.size();
    }

    public static void addToCart(Product product) {
        cart.add(product);
    }

    public static void removeFromCart(Product product) {
        cart.remove(product);
    }

    public static void clearCart() {
        cart.clear();
    }
}
