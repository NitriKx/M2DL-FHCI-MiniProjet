package com.lifo.upspoi.model;

import com.lifo.upspoi.Utils.Color;
import com.lifo.upspoi.model.converters.ColorTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@Table(database = BaseDeDonneeLocale.class)
public class PointTag extends BaseModel {

    @PrimaryKey
    private Long id;

    @Column
    private String nomTag;

    @Column(typeConverter = ColorTypeConverter.class)
    private Color couleur;

    public PointTag() {
        super();
        nomTag = null;
    }

    public PointTag(Long id, String nomTag) {
        this(id, nomTag, null);
    }

    public PointTag(Long id, String nomTag, Color couleur) {
        super();
        this.id = id;
        this.nomTag = nomTag;
        this.couleur = couleur;
    }

    public String getNomTag() {
        return nomTag;
    }

    public void setNomTag(String nomTag) {
        this.nomTag = nomTag;
    }

    @Override
    public String toString() {
        return getNomTag();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
