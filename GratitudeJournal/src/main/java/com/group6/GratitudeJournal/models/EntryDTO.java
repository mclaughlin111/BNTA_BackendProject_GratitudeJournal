package com.group6.GratitudeJournal.models;

public class EntryDTO {

    private String content;
    private MoodRating moodRating;
    private WeekDay weekDay;

    public EntryDTO(String content, MoodRating moodRating, WeekDay weekDay) {
        this.content = content;
        this.moodRating = moodRating;
        this.weekDay = weekDay;
    }
    public EntryDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodRating getMoodRating() {
        return moodRating;
    }

    public void setMoodRating(MoodRating moodRating) {
        this.moodRating = moodRating;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }
}
