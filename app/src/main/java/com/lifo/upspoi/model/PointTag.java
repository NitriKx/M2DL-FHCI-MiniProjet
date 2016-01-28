package com.lifo.upspoi.model;

import com.lifo.upspoi.Utils.Color;
import com.lifo.upspoi.model.converters.ColorTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class PointTag extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column(name = "point_id")
    public int point_id;

    @Column
    public String nomTag;

    @Column(typeConverter = ColorTypeConverter.class)
    public Color couleur;

    public PointTag() {
        super();
    }

    public PointTag(String nomTag) {
        this(nomTag, null);
    }

    public PointTag(String nomTag, Color couleur) {
        super();
        this.nomTag = nomTag;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return nomTag;
    }

}
