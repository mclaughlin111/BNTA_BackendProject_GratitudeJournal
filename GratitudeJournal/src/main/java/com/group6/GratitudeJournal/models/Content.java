package com.group6.GratitudeJournal.models;

import java.util.ArrayList;

public class Content {

    private long id;
    private ArrayList<String> fiveEntries;


    public Content() {
        this.fiveEntries = new ArrayList<>(5);
    }

    public ArrayList<String> getFiveEntries() {
        return fiveEntries;
    }

    public void setFiveEntries(ArrayList<String> fiveEntries) {
        this.fiveEntries = fiveEntries;
    }

}
