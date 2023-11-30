package com.example.pfi;

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

    public Boolean ValidateLogin(String username, String password) {
        if (Username.equals(username) && Password.equals(password))
            return true;
        else
            return false;
    }
}
