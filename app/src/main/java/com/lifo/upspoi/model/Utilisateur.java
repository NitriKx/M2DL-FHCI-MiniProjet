package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class Utilisateur extends BaseModel {

    @PrimaryKey
    @Column(name = "utilisateur_id")
    public int utilisateur_id;

    @Column
    public String nomUtilisateur;

    @Column
    public String hachedPassword;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String nomUtilisateur, String hachedPassword) {
        super();
        this.nomUtilisateur = nomUtilisateur;

        // TODO: Hacher le mot de passe
        this.hachedPassword = hachedPassword;
    }

}
