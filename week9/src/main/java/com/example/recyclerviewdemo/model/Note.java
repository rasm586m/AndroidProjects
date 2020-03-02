package com.example.recyclerviewdemo.model;

import java.io.Serializable;

public class Note implements Serializable {

    public String headline;
    public String text;
    public int id;
    static final long serialVersionUID = 42L;


    public Note() {

    }

    public Note(String headline, String text) {
        this.headline = headline;
        this.text = text;
    }

    public Note(int id, String headline, String text) {
        this.headline = headline;
        this.text = text;
        this.id = id;

    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}