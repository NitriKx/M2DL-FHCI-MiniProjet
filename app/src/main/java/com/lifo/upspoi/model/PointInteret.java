package com.lifo.upspoi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class PointInteret {

    private LatLng position;

    private String nom;

    private List<Tag> tagsAssocies;

    private Image image;

    public PointInteret(LatLng position, String nom, List<Tag> tagsAssocies, Image image) {
        this.position = position;
        this.nom = nom;
        this.tagsAssocies = tagsAssocies;
        this.image = image;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
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
