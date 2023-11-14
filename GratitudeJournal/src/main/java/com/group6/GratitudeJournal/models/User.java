package com.group6.GratitudeJournal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Table(name = "users")
@Entity(name = "users") // CHECK difference in @Table vs @Entity!
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Column needed here?
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "emailAddress")
    private String emailAddress;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    List<JournalEntry> journalEntries;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.journalEntries = new ArrayList<>();
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
