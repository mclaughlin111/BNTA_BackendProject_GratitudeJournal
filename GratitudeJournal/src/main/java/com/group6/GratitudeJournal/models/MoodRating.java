package com.group6.GratitudeJournal.models;

public enum MoodRating {

    REALLYBAD(1),
    NEGATIVE(2),
    INDIFFERENT(3),
    POSITIVE(4),
    REALLYGOOD(5);

    int rating;

    MoodRating(int rating){
        this.rating = rating;
    }

}
