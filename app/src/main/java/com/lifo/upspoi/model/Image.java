package com.lifo.upspoi.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
@ModelContainer
@Table(database = BaseDeDonneeLocale.class)
public class Image extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private Long id;

    @Column
    private String imageURL;

    @Column
    @ForeignKey
    private Utilisateur createur;

    public Image() {
        super();
    }

    public Image(Long id, String imageURL, Utilisateur createur) {
        super();
        this.id = id;
        this.imageURL = imageURL;
        this.createur = createur;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }
}
