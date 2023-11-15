package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.models.*;
import com.group6.GratitudeJournal.repositories.JournalEntryRepository;
import com.group6.GratitudeJournal.services.JournalEntryService;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/journal-entries")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @Autowired
    UserService userService;

    @Autowired
    JournalEntryRepository journalEntryRepository;


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

//    add a new journal entry by user Id - tested ✅
    @PostMapping(value = "/{id}")
    public ResponseEntity<JournalEntry> addNewJournalEntry(@PathVariable long id, @RequestBody JournalEntry journalEntry){
//        do we need to access through service layer? -- (YES WE DO)
        User foundUser = userService.getUserById(id);
//        JournalEntry newJournalEntry = journalEntryService.addNewJournalEntry(journalEntry);
        foundUser.addJournalEntry(journalEntry);
        return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
    }


//  @PATCH Update journal entry by User ID

    @PatchMapping(value = "/{id}") // - tested ✅ pass journal entry obj?
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable long id, @RequestBody EntryDTO entryDTO) {
        JournalEntry updatedJournalEntry = journalEntryService.updateJournalEntry(id, entryDTO);
        return new ResponseEntity<>(updatedJournalEntry, HttpStatus.OK);
    }

//    @PutMapping // to fully update





}
