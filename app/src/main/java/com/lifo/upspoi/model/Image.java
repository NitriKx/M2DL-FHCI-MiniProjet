package com.lifo.upspoi.model;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class Image {

    private String imageURL;

    public Image(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
