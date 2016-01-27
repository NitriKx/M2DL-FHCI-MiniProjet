package com.lifo.upspoi.services;

import android.util.Log;

import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.Utilisateur;
import com.lifo.upspoi.model.UtilisateurAuthentifie;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class UtilisateurService {

    public UtilisateurAuthentifie utilisateurAuthentifie = null;

    public boolean estLoggue() {
        UtilisateurAuthentifie loggedInUser = getUtilisateurConnecte();
        return loggedInUser != null;
    }

    public UtilisateurAuthentifie getUtilisateurConnecte() {
        List<UtilisateurAuthentifie> all = SQLite.select().from(UtilisateurAuthentifie.class).queryList();
        if (all.size() > 0) {
            return all.get(0);
        } else {
            return null;
        }
    }

    public Utilisateur loggerUtilisateur(String nomUtilisateur, String passwordEnClair) {
        Utilisateur utilisateurConnecte = new Utilisateur(nomUtilisateur, passwordEnClair);
        utilisateurConnecte.save();
        Log.i("LOGIN", "Authentification de l'utilisateur = " + utilisateurConnecte.nomUtilisateur);

        this.utilisateurAuthentifie = new UtilisateurAuthentifie(utilisateurConnecte, new Date());
        this.utilisateurAuthentifie.save();

        return utilisateurConnecte;
    }

    //
    //  SINGLETON
    //

    private static final UtilisateurService __instance = new UtilisateurService();

    private UtilisateurService() {
        // On essaie de voir si l'utilisateur s'est déjà loggué avant
        if (estLoggue()) {
            this.utilisateurAuthentifie = getUtilisateurConnecte();
            Log.i("LOGIN", "Utilisateur déjà loggué = " + this.utilisateurAuthentifie.loggedInUser.nomUtilisateur);
        } else {
            Log.i("LOGIN", "Utilisateur pas encore loggué");
        }
    }

    public static UtilisateurService getInstance() {
        return __instance;
    }

}
