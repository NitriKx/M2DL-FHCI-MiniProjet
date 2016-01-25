package com.lifo.upspoi.model;

import com.lifo.upspoi.Utils.Color;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.collect.Lists;
import com.lifo.upspoi.model.converters.ListLatLngTypeConverter;
import com.lifo.upspoi.model.converters.ListPointTagTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class ElementDeCarte  extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private Long id;

    @Column
    private String nom;

    @Column(typeConverter = ListPointTagTypeConverter.class)
    // DOIT être une liste de PointTag
    private List tagsAssocies;

    @Column
    @ForeignKey
    private Image image;

    @Column(typeConverter = ListLatLngTypeConverter.class)
    // DOIT être une liste de LatLng
    private List points;

    public ElementDeCarte() {
        super();
    }

    public ElementDeCarte(Long id, String nom, List<PointTag> tagsAssocies, Image image, LatLng point) {
        this(id, nom, tagsAssocies, image, Lists.newArrayList(point));
    }

    public ElementDeCarte(Long id, String nom, List<PointTag> tagsAssocies, Image image, List<LatLng> points) {
        super();
        this.id = id;
        this.nom = nom;
        this.tagsAssocies = tagsAssocies;
        this.image = image;
        this.points = points;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<PointTag> getTagsAssocies() {
        return tagsAssocies;
    }

    public void setTagsAssocies(List<PointTag> tagsAssocies) {
        this.tagsAssocies = tagsAssocies;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public Color getCouleur() {
        for (Object o : tagsAssocies) {
            PointTag tag = (PointTag) o;
            if (!tag.getNomTag().equals("recyclage")) {
                return tag.getCouleur();
            }
        }
        return new Color(190,190,190);
    }

    public String getNomTags() {
        StringBuilder resultat = new StringBuilder();
        for (Object o : tagsAssocies) {
            PointTag tag = (PointTag) o;
            resultat.append("["+tag.getNomTag()+"]");
        }
        return resultat.toString();
    }

    public List<LatLng> getPoints() {
        return points;
    }

    public void setPoints(List<LatLng> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "ElementDeCarte{" +
                "nom='" + nom + '\'' +
                ", tagsAssocies=" + tagsAssocies +
                ", image=" + image +
                ", points=" + points +
                '}';
    }

}
