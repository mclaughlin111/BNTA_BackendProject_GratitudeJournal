package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal-entries")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    //find all
    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries(){
        return new ResponseEntity<>(journalEntryService.getAllEntries(), HttpStatus.OK);
    }


}
