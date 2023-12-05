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

    /**
     * Crée un nouveau client.
     * @param username Le nom d'utilisateur du client.
     * @param password Le mot de passe du client.
     */
    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Vérifie que les informations de connexion sont valides.
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @return Retourne vrai si le nom d'utilisateur et le mot de passe correspondent à un client.
     */
    public Boolean validateLogin(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password))
            return true;
        else
            return false;
    }
}
