package com.lifo.upspoi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by benoit on 21/01/16.
 */
public class ZoneRectangulaireInteret extends ElementDeCarte {

    private LatLng topLeft;

    private LatLng bottomRight;

    public ZoneRectangulaireInteret(String nom, List<Tag> tagsAssocies, Image image, LatLng topLeft, LatLng bottomRight) {
        super(nom, tagsAssocies, image);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public LatLng getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(LatLng topLeft) {
        this.topLeft = topLeft;
    }

    public LatLng getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(LatLng bottomRight) {
        this.bottomRight = bottomRight;
    }
}
