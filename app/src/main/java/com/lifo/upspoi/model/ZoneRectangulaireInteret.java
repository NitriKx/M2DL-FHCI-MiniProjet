package com.lifo.upspoi.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Polygon;

import java.util.List;

/**
 * Created by benoit on 21/01/16.
 */
public class ZoneRectangulaireInteret extends ElementDeCarte {

    private List<LatLng> polygon;

    public ZoneRectangulaireInteret(String nom, List<Tag> tagsAssocies, Image image, List<LatLng> polygon) {
        super(nom, tagsAssocies, image);
        this.polygon = polygon;
    }

    public List<LatLng> getPolygon() {
        return polygon;
    }

    public void setPolygon(List<LatLng> polygon) {
        this.polygon = polygon;
    }
}
