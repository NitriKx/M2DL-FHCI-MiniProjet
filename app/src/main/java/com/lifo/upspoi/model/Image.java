package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class Image extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column(name = "image_id")
    public int image_id;

    @Column
    public String imageURL;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    public Utilisateur createur;

    public Image() {
        super();
    }

    public Image(String imageURL, Utilisateur createur) {
        super();
        this.imageURL = imageURL;
        this.createur = createur;
    }

}
