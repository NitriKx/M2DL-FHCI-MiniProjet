package com.lifo.upspoi.model;


import com.lifo.upspoi.Utils.Color;

/**
 * Created by benoit on 21/01/16.
 */
public class Tag {
    private String nomTag;
    private Color couleur;

    public Tag(String nomTag) {
        this.nomTag = nomTag;
        this.couleur=null;
    }

    public Tag(String nomTag, int rouge, int vert, int bleu) {
        this(nomTag);
        this.couleur = new Color(rouge, vert, bleu);
    }

    public String getNomTag() {
        return nomTag;
    }

    public Color getCouleur() {return couleur;}

    @Override
    public String toString() {
        return getNomTag();
    }
}
