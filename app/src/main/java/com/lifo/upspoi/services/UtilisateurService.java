package com.lifo.upspoi.services;

import com.lifo.upspoi.model.Utilisateur;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class UtilisateurService {

    /**
     * Cet attribut devrait en fait être stocké dans un base de données locale, afin que
     * l'utilisateur n'ai pas à se logguer à chaque fois qu'il ré-ouvre l'application.
     */
    public Utilisateur utilisateurConnecte = null;

    public boolean estLoggue() {
        return this.utilisateurConnecte != null;
    }

    public Utilisateur getUtilisateurConnecte() {
        return utilisateurConnecte;
    }

    public Utilisateur loggerUtilisateur(String nomUtilisateur, String passwordEnClair) {
        this.utilisateurConnecte = new Utilisateur(nomUtilisateur, passwordEnClair);
        return getUtilisateurConnecte();
    }

    //
    //  SINGLETON
    //

    private static final UtilisateurService __instance = new UtilisateurService();

    private UtilisateurService() {}

    public static UtilisateurService getInstance() {
        return __instance;
    }

}
