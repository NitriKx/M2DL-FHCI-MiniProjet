package com.lifo.upspoi.model;

/**
 * Created by benoit on 21/01/16.
 */
public class Tag {
    private String nomTag;

    public Tag(String nomTag) {
        this.nomTag = nomTag;
    }

    public String getNomTag() {
        return nomTag;
    }

    @Override
    public String toString() {
        return getNomTag();
    }
}
