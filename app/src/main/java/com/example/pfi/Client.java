package com.example.pfi;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String Username;
    private String Password;

    public Client(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public Boolean validateLogin(String username, String password) {
        if (Username.equals(username) && Password.equals(password))
            return true;
        else
            return false;
    }
}
