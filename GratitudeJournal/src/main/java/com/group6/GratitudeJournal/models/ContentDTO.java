package com.group6.GratitudeJournal.models;

public class ContentDTO {

    private String content;

    public ContentDTO(String content) {
        this.content = content;
    }

    public ContentDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
