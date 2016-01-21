package com.lifo.upspoi.services;

import com.lifo.upspoi.model.Utilisateur;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class UtilisateurService {


    public Utilisateur getUtilisateurPourPseudo(String pseudo) {
        return null;
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
