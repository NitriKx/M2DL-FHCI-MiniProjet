package com.lifo.upspoi.model;

import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class ElementDeCarte {

    private String nom;

    private List<Tag> tagsAssocies;

    private Image image;


    public ElementDeCarte(String nom, List<Tag> tagsAssocies, Image image) {
        this.nom = nom;
        this.tagsAssocies = tagsAssocies;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Tag> getTagsAssocies() {
        return tagsAssocies;
    }

    public void setTagsAssocies(List<Tag> tagsAssocies) {
        this.tagsAssocies = tagsAssocies;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
