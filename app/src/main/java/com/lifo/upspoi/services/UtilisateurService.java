package com.lifo.upspoi.services;

import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.lifo.upspoi.model.Utilisateur;
import com.lifo.upspoi.model.db.UtilisateurAuthentifie;

import java.util.Date;

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
        return new Select().from(UtilisateurAuthentifie.class).executeSingle();
    }

    public Utilisateur loggerUtilisateur(String nomUtilisateur, String passwordEnClair) {
        Utilisateur utilisateurConnecte = new Utilisateur(nomUtilisateur, passwordEnClair);
        utilisateurConnecte.save();
        Log.i("LOGIN", "Authentification de l'utilisateur = " + utilisateurConnecte.getNomUtilisateur());

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
            Log.i("LOGIN", "Utilisateur déjà loggué = " + this.utilisateurAuthentifie.getLoggedInUser().getNomUtilisateur());
        } else {
            Log.i("LOGIN", "Utilisateur pas encore loggué");
        }
    }

    public static UtilisateurService getInstance() {
        return __instance;
    }

}
