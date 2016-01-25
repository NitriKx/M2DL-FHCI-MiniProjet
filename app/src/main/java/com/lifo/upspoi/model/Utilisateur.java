package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@Table(database = BaseDeDonneeLocale.class)
public class Utilisateur extends BaseModel {

    @PrimaryKey
    private String nomUtilisateur;

    @Column
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
