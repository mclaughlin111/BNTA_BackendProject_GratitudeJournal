package com.group6.GratitudeJournal.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "journal_entries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entryId;
//    userId
    @Column(name = "user")
    private User user;
//    private LocalDate dateAndTime;
    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day")
    private WeekDay weekDay;

    @Enumerated(EnumType.ORDINAL) // can be .ORDINAL or .STRING
    @Column(name = "mood_rating")
    private MoodRating moodRating;

    public JournalEntry(User user, String content, WeekDay weekDay, MoodRating moodRating) {
        this.user = user;
        this.content = content;
        this.weekDay = weekDay;
        this.moodRating = moodRating;
    }

    public JournalEntry(){
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public MoodRating getMoodRating() {
        return moodRating;
    }

    public void setMoodRating(MoodRating moodRating) {
        this.moodRating = moodRating;
    }
}