package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class UtilisateurAuthentifie extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public int id;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    public Utilisateur loggedInUser;

    @Column
    public Date lastLoginDate;

    public UtilisateurAuthentifie(Utilisateur loggedInUser, Date lastLoginDate) {
        super();
        this.loggedInUser = loggedInUser;
        this.lastLoginDate = lastLoginDate;
    }

    public UtilisateurAuthentifie() {
        super();
    }

}
