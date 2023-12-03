package com.example.pfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private static List<Product> inventory = new ArrayList<>();

    public static List<Product> getInventory() {
        return inventory;
    }

    public static void setInventory(Product[] product) {
        inventory.clear();
        inventory.addAll(Arrays.asList(product));
    }

    public static void purchase(List<Product> products, Boolean isFromCart) {
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (inventory.get(i).getName().equals(products.get(j).getName())) {
                    if (inventory.get(i).getStock() == 1) {
                        inventory.remove(i);
                    } else {
                        inventory.get(i).buyProduct(1);
                    }
                }
            }
        }
        if (isFromCart) {
            Cart.clearCart();
        }
    }
}
