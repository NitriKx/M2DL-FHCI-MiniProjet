package com.lifo.upspoi.model;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class Utilisateur {

    private String nomUtilisateur;

    private String hachedPassword;

    public Utilisateur(String nomUtilisateur, String hachedPassword) {
        this.nomUtilisateur = nomUtilisateur;
        this.hachedPassword = hachedPassword;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getHachedPassword() {
        return hachedPassword;
    }

    public void setHachedPassword(String hachedPassword) {
        this.hachedPassword = hachedPassword;
    }
}
