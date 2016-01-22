package com.lifo.upspoi.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@Table(name = "Utilisateur")
public class Utilisateur extends Model {

    @Column(name = "nomUtilisateur", unique = true)
    private String nomUtilisateur;

    @Column(name = "hachedPassword")
    private String hachedPassword;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String nomUtilisateur, String hachedPassword) {
        super();
        this.nomUtilisateur = nomUtilisateur;

        // TODO: Hacher le mot de passe
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
