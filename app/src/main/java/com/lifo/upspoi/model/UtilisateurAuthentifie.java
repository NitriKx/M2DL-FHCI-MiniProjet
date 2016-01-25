package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
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
    private Long id;

    @Column
    @ForeignKey
    private Utilisateur loggedInUser;

    @Column
    private Date lastLoginDate;

    public UtilisateurAuthentifie(Long id, Utilisateur loggedInUser, Date lastLoginDate) {
        super();
        this.id = id;
        this.loggedInUser = loggedInUser;
        this.lastLoginDate = lastLoginDate;
    }

    public UtilisateurAuthentifie() {
        super();
    }

    public Utilisateur getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Utilisateur loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
