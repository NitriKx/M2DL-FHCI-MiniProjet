package com.lifo.upspoi.model;

import com.lifo.upspoi.Utils.Color;

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

    public Color getCouleur() {
        for (Tag tag:tagsAssocies
             ) {
            if (!tag.getNomTag().equals("recyclage")) {
                return tag.getCouleur();
            }
        }
        return new Color(190,190,190);
    }

    public String getNomTags() {
        StringBuilder resultat = new StringBuilder();
        for (Tag tag:tagsAssocies
             ) {
            resultat.append("["+tag.getNomTag()+"]");
        }
        return resultat.toString();
    }
}
