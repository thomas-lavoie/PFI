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

    /**
     * Enlève les produits achetés de l'inventaire ou diminue le stock, puis nettoie le panier si l'achat a été fait à partir d'un panier.
     * @param products Les produits à enlever/diminuer.
     * @param isFromCart Indique si l'achat a été effectué à partir d'un panier.
     */
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
