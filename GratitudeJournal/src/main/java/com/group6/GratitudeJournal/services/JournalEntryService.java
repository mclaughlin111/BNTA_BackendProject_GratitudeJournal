package com.group6.GratitudeJournal.services;


import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.repositories.JournalEntryRepository;
import com.group6.GratitudeJournal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    JournalEntryRepository journalEntryRepository;

    @Autowired
    UserRepository userRepository;


//  find all
    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }



//    find by entry ID
    public JournalEntry findEntryById(long id){
        return journalEntryRepository.findById(id).get();
    }


//    find all by userID - could consider using derived query in future
    public List<JournalEntry> findEntryByUserId(long id){
        User user = userRepository.findById(id).get();
        return user.getJournalEntries();
    }

//    add new journal entry
    public JournalEntry addNewJournalEntry(JournalEntry journalEntry){ //make it void?
        journalEntryRepository.save(journalEntry);
        return journalEntry;

    }

//    delete journal entry
    public void deleteJournalEntry(long id){
        journalEntryRepository.deleteById(id);
    }

//    update journal entry
//    public void updateJournalEntry(JournalEntry journalEntry){
//        JournalEntry journalEntry = journalEntry
//        journalEntry.setContent();
//    }

//    method to work out which parameter updating

    public


}
