package com.example.pfi;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String username;
    private String password;
    private static Client loggedInClient;

    public static Client getLoggedInClient() {
        return Client.loggedInClient;
    }

    public static void setLoggedInClient(Client loggedInClient) {
        Client.loggedInClient = loggedInClient;
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Boolean validateLogin(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password))
            return true;
        else
            return false;
    }
}
