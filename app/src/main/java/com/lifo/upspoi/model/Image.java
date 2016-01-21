package com.lifo.upspoi.model;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class Image {

    private String imageURL;

    private Utilisateur createur;

    public Image(String imageURL, Utilisateur createur) {
        this.imageURL = imageURL;
        this.createur = createur;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }
}
