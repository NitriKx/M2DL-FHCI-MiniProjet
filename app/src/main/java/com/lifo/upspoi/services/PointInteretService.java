package com.lifo.upspoi.services;

import android.net.Uri;
import android.nfc.Tag;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.ElementDeCarte_Adapter;
import com.lifo.upspoi.model.ElementDeCarte_Table;
import com.lifo.upspoi.model.Image;
import com.lifo.upspoi.model.Image_Table;
import com.lifo.upspoi.model.PointTag;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class PointInteretService {

    public Map<String, PointTag> getTagsDeclare() {
        List<PointTag> listeTagDansLaBase = SQLite.select().from(PointTag.class).queryList();
        ImmutableMap.Builder<String, PointTag> listeTagIndexee = ImmutableMap.builder();

        for (PointTag t : listeTagDansLaBase) {
            listeTagIndexee.put(t.nomTag, t);
        }

        return listeTagIndexee.build();
    }

    public List<? extends ElementDeCarte> getElementDeCarteDansZone(Polygon zone) {
        return SQLite.select().from(ElementDeCarte.class).queryList();
    }

    public Uri getPhotoURLForMarkerId(Integer markerId) {
        try {
            Image imageAssociee = SQLite.select().from(Image.class).as("Image").crossJoin(ElementDeCarte.class).as("ElementDeCarte").on(ElementDeCarte_Table.ref_image_id.eq(Image_Table.image_id)).querySingle();
            return new Uri.Builder().path(imageAssociee.imageURL).build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ElementDeCarte getElementDeCarteParId (Integer id) {
        return SQLite.select().from(ElementDeCarte.class).where(ElementDeCarte_Table.element_id.eq(id)).querySingle();
    }

    public ElementDeCarte ajouterElement(String nom, List<PointTag> tagsAssocies, String imageURI, LatLng point) {
        Image imageAssociee = new Image(imageURI, null);
        imageAssociee.save();
        ElementDeCarte nouvelElementDeCarte = new ElementDeCarte(nom, tagsAssocies, imageAssociee, point);
        nouvelElementDeCarte.save();
        return nouvelElementDeCarte;
    }

    public List<LatLng> getDelimitationFac() {
        List<LatLng> delimitationFac = new ArrayList<>();

        delimitationFac.add(new LatLng(43.561269,1.462641));
        delimitationFac.add(new LatLng(43.559978,1.463370));
        delimitationFac.add(new LatLng(43.558361,1.464357));
        delimitationFac.add(new LatLng(43.556137,1.466074));
        delimitationFac.add(new LatLng(43.555919,1.466331));
        delimitationFac.add(new LatLng(43.555313,1.467297));
        delimitationFac.add(new LatLng(43.554396,1.469142));
        delimitationFac.add(new LatLng(43.554131,1.471074));
        delimitationFac.add(new LatLng(43.554084,1.471610));
        delimitationFac.add(new LatLng(43.554675,1.472104));
        delimitationFac.add(new LatLng(43.555204,1.472511));
        delimitationFac.add(new LatLng(43.555671,1.473434));
        delimitationFac.add(new LatLng(43.555982,1.473927));
        delimitationFac.add(new LatLng(43.556417,1.474764));
        delimitationFac.add(new LatLng(43.557132,1.475987));
        delimitationFac.add(new LatLng(43.557319,1.477532));
        delimitationFac.add(new LatLng(43.557459,1.479335));
        delimitationFac.add(new LatLng(43.558213,1.478434));
        delimitationFac.add(new LatLng(43.559659,1.476513));
        delimitationFac.add(new LatLng(43.561331,1.474743));
        delimitationFac.add(new LatLng(43.562925,1.472543));
        delimitationFac.add(new LatLng(43.563500,1.471953));
        delimitationFac.add(new LatLng(43.564091,1.471696));
        delimitationFac.add(new LatLng(43.565210,1.471707));
        delimitationFac.add(new LatLng(43.565436,1.472468));
        delimitationFac.add(new LatLng(43.564689,1.473885));
        delimitationFac.add(new LatLng(43.563508,1.475086));
        delimitationFac.add(new LatLng(43.563134,1.475472));
        delimitationFac.add(new LatLng(43.564783,1.478992));
        delimitationFac.add(new LatLng(43.562264,1.481395));
        delimitationFac.add(new LatLng(43.562481,1.483197));
        delimitationFac.add(new LatLng(43.562544,1.484356));
        delimitationFac.add(new LatLng(43.563414,1.486459));
        delimitationFac.add(new LatLng(43.566897,1.482210));
        delimitationFac.add(new LatLng(43.568980,1.478863));
        delimitationFac.add(new LatLng(43.570535,1.476073));
        delimitationFac.add(new LatLng(43.570846,1.474743));
        delimitationFac.add(new LatLng(43.571281,1.474142));
        delimitationFac.add(new LatLng(43.572587,1.472683));
        delimitationFac.add(new LatLng(43.573240,1.471438));
        delimitationFac.add(new LatLng(43.572991,1.470108));
        delimitationFac.add(new LatLng(43.574142,1.469293));
        delimitationFac.add(new LatLng(43.574111,1.468005));
        delimitationFac.add(new LatLng(43.573738,1.466675));
        delimitationFac.add(new LatLng(43.573054,1.465516));
        delimitationFac.add(new LatLng(43.572307,1.464100));
        delimitationFac.add(new LatLng(43.571872,1.462727));
        delimitationFac.add(new LatLng(43.571841,1.461825));
        delimitationFac.add(new LatLng(43.571592,1.462297));
        delimitationFac.add(new LatLng(43.570970,1.463585));
        delimitationFac.add(new LatLng(43.570566,1.464100));
        delimitationFac.add(new LatLng(43.569478,1.464272));
        delimitationFac.add(new LatLng(43.568359,1.464443));
        delimitationFac.add(new LatLng(43.567799,1.464443));
        delimitationFac.add(new LatLng(43.567830,1.463628));
        delimitationFac.add(new LatLng(43.567892,1.462598));
        delimitationFac.add(new LatLng(43.567892,1.461825));
        delimitationFac.add(new LatLng(43.567612,1.461139));
        delimitationFac.add(new LatLng(43.567395,1.460581));
        delimitationFac.add(new LatLng(43.568048,1.459937));
        delimitationFac.add(new LatLng(43.566959,1.458650));
        delimitationFac.add(new LatLng(43.566368,1.458993));
        delimitationFac.add(new LatLng(43.564658,1.455946));
        delimitationFac.add(new LatLng(43.563881,1.456504));
        delimitationFac.add(new LatLng(43.563694,1.456375));
        delimitationFac.add(new LatLng(43.563274,1.456890));
        delimitationFac.add(new LatLng(43.564969,1.459851));
        delimitationFac.add(new LatLng(43.564285,1.460409));
        delimitationFac.add(new LatLng(43.561922,1.456568));
        delimitationFac.add(new LatLng(43.560149,1.457469));
        delimitationFac.add(new LatLng(43.561502,1.458242));
        delimitationFac.add(new LatLng(43.562093,1.459122));
        delimitationFac.add(new LatLng(43.563414,1.460667));
        delimitationFac.add(new LatLng(43.563787,1.461375));
        delimitationFac.add(new LatLng(43.561269,1.462668));

        return delimitationFac;
    }

    //
    //  SINGLETON
    //

    private static final PointInteretService __instance = new PointInteretService();

    private PointInteretService() {
    }

    public static PointInteretService getInstance() {
        return __instance;
    }


}
