package com.group6.GratitudeJournal.models;

public class EntryDTO {

    private Content content;
    private MoodRating moodRating;
    private WeekDay weekDay;

    public EntryDTO(Content content, MoodRating moodRating, WeekDay weekDay) {
        this.content = content;
        this.moodRating = moodRating;
        this.weekDay = weekDay;
    }
    public EntryDTO() {
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
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
