package com.example.pfi;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String Username;
    private String Password;
    private List<Product> Cart;

    public Client(String username, String password) {
        Username = username;
        Password = password;
        Cart = new ArrayList<>();
    }

    public String getUsername() {
        return Username;
    }

    public List<Product> getCart() {
        return Cart;
    }

    public Boolean ValidateLogin(String username, String password) {
        if (Username.equals(username) && Password.equals(password))
            return true;
        else
            return false;
    }

    public void AddToCart(Product product) {
        Cart.add(product);
    }

    public void RemoveFromCart(Product product) {
        Cart.remove(product);
    }

    public void ClearCart() {
        Cart.clear();
    }
}
