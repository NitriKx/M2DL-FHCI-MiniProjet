package com.lifo.upspoi.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.List;

/**
 * Created by benoit on 21/01/16.
 */
public class ZoneRectangulaireInteret extends ElementDeCarte {

    private LatLngBounds bounds;

    public ZoneRectangulaireInteret(String nom, List<Tag> tagsAssocies, Image image, LatLngBounds bounds) {
        super(nom, tagsAssocies, image);
        this.bounds = bounds;
    }

    public LatLngBounds getBounds() {
        return bounds;
    }

    public void setBounds(LatLngBounds bounds) {
        this.bounds = bounds;
    }
}
