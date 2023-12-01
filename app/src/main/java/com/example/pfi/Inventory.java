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

    public static void purchase() {
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = 0; j < Cart.count(); j++) {
                if (inventory.get(i).getName().equals(Cart.getCart().get(j).getName())) {
                    if (inventory.get(i).getStock() == 1) {
                        inventory.remove(i);
                    } else {
                        inventory.get(i).buyProduct(1);
                    }
                    Cart.removeFromCart(Cart.getCart().get(j));
                }
            }
        }
        Cart.clearCart();
    }
}
