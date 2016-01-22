package com.lifo.upspoi.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.lifo.upspoi.model.Utilisateur;

import java.util.Date;

/**
 * Created by benoit on 21/01/16.
 */
@Table(name = "UtilisateurAuthentifie")
public class UtilisateurAuthentifie extends Model {

    @Column(name = "utilisateur")
    private Utilisateur loggedInUser;

    @Column(name = "derniereConnexion")
    private Date lastLoginDate;

    public UtilisateurAuthentifie(Utilisateur loggedInUser, Date lastLoginDate) {
        super();
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
}
