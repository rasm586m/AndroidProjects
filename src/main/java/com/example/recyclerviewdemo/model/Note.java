package com.example.recyclerviewdemo.model;

public class Note {

    public String headline;
    public String text;


    public Note() {

    }

    public Note(String headline, String text) {
        this.headline = headline;
        this.text = text;
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
}