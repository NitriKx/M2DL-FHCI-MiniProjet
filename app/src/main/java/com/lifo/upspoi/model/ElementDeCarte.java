package com.lifo.upspoi.model;

import com.lifo.upspoi.Utils.Color;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.collect.Lists;
import com.lifo.upspoi.model.converters.ListLatLngTypeConverter;
import com.lifo.upspoi.model.converters.ListPointTagTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
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
    @Column(name = "element_id")
    public int element_id;

    @Column
    public String nom;

    @Column(typeConverter = ListPointTagTypeConverter.class)
    // DOIT être une liste de PointTag
    public List tagsAssocies;

    @Column
    @ForeignKey(saveForeignKeyModel = false, references = @ForeignKeyReference(columnName = "ref_image_id", columnType = int.class, foreignKeyColumnName = "image_id"))
    public Image image;

    @Column(typeConverter = ListLatLngTypeConverter.class)
    // DOIT être une liste de LatLng
    public List points;

    public ElementDeCarte() {
        super();
    }

    public ElementDeCarte(String nom, List<PointTag> tagsAssocies, Image image, LatLng point) {
        this(nom, tagsAssocies, image, Lists.newArrayList(point));
    }

    public ElementDeCarte(String nom, List<PointTag> tagsAssocies, Image image, List<LatLng> points) {
        super();
        this.nom = nom;
        this.tagsAssocies = tagsAssocies;
        this.image = image;
        this.points = points;
    }

    public Color getCouleur() {
        for (Object o : tagsAssocies) {
            PointTag tag = (PointTag) o;
            if (!tag.nomTag.equals("recyclage")) {
                return tag.couleur;
            }
        }
        return new Color(190,190,190);
    }

    public String getNomTags() {
        StringBuilder resultat = new StringBuilder();
        for (Object o : tagsAssocies) {
            PointTag tag = (PointTag) o;
            resultat.append("["+tag.nomTag+"]");
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
