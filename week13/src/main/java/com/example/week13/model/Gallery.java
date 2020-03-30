package com.example.week13.model;


public class Gallery {

    public String headline;
    public int image;

    public Gallery(String headline, int image) {
        this.headline = headline;
        this.image = image;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
