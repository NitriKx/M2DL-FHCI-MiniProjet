package com.lifo.upspoi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class PointInteret extends ElementDeCarte {

    private LatLng position;

    public PointInteret(String nom, List<Tag> tagsAssocies, Image image, LatLng position) {
        super(nom, tagsAssocies, image);
        this.position = position;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

}
