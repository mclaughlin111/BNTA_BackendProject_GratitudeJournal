package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.models.UserDTO;
import com.group6.GratitudeJournal.services.JournalEntryService;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal-entries")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @Autowired
    UserService userService;


    //find all - tested ✅
    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries(){
        return new ResponseEntity<>(journalEntryService.getAllEntries(), HttpStatus.OK);
    }

//    find journal entries by Id - tested ✅
    @GetMapping(value = "/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable long id){
        JournalEntry journalEntry = journalEntryService.findEntryById(id);
        return new ResponseEntity<>(journalEntry, HttpStatus.OK);
    }

//    add a new journal entry by user Id
    @PostMapping(value = "/{id}")
    public ResponseEntity<JournalEntry> addNewJournalEntry(@PathVariable long id, @RequestBody JournalEntry journalEntry){
//        do we need to access through service layer?
        User foundUser = userService.getUserById(id);
        JournalEntry newJournalEntry = journalEntryService.addNewJournalEntry(journalEntry);
        foundUser.addJournalEntry(journalEntry);
        return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
    }





}
