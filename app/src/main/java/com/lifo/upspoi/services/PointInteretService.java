package com.lifo.upspoi.services;

import com.google.android.gms.maps.model.LatLng;
import com.lifo.upspoi.model.PointInteret;

import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class PointInteretService {

    public List<PointInteret> getPointInteretDansZone(LatLng topleft, LatLng bottomright) {
        return null;
    }


    //
    //  SINGLETON
    //

    private static final PointInteretService __instance = new PointInteretService();

    private PointInteretService() {}

    public static PointInteretService getInstance() {
        return __instance;
    }

}
