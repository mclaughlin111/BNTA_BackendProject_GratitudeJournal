package com.group6.GratitudeJournal.models;

public class UserDTO {

    private long userId;

    public UserDTO(long userId) {
        this.userId = userId;
    }

    public UserDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
