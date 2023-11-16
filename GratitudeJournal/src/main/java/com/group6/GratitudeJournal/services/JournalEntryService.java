package com.group6.GratitudeJournal.services;


import com.group6.GratitudeJournal.models.EntryDTO;
import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.repositories.JournalEntryRepository;
import com.group6.GratitudeJournal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    JournalEntryRepository journalEntryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    //  find all
    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }


    //    find by entry ID
    public JournalEntry findEntryById(long id) {
        return journalEntryRepository.findById(id).get();
    }


    //    find all by userID - could consider using derived query in future
    public List<JournalEntry> findEntryByUserId(long id) {
        User user = userRepository.findById(id).get();
        return user.getJournalEntries();
    }

    //    add new journal entry
    public boolean addNewJournalEntry(long id, JournalEntry journalEntry) { //make it void?
        User foundUser = userService.getUserById(id);
        List<JournalEntry> entryCount = journalEntryRepository.findByWeekDayAndUserId(journalEntry.getWeekDay(), foundUser.getId());

        if (entryCount.size() < 5){
            journalEntry.setUser(foundUser);
            journalEntryRepository.save(journalEntry);
            return true;

        } else {
            return false;
        }
    }

    //    delete journal entry
    public void deleteJournalEntry(long id) {
        journalEntryRepository.deleteById(id);
    }

//    Update journal entry

    // @TRANSACTIONAL NEEDED?
    public JournalEntry updateJournalEntry(long id, EntryDTO entryDTO) {
        // Find existing Journal Entry
        JournalEntry updatedJournalEntry = journalEntryRepository.findById(id).get();
        // Compare existing to given entry from DTO

        //if updated content
        if (!updatedJournalEntry.getContent().equals(entryDTO.getContent())) {
            updatedJournalEntry.setContent(entryDTO.getContent());
        }

        //if updated weekday
        if (!updatedJournalEntry.getWeekDay().equals(entryDTO.getWeekDay())) {
            updatedJournalEntry.setWeekDay(entryDTO.getWeekDay());
        }

        //if updated mood
        if (!updatedJournalEntry.getMoodRating().equals(entryDTO.getMoodRating())) {
            updatedJournalEntry.setMoodRating(entryDTO.getMoodRating());
        }

        //save updated
        journalEntryRepository.save(updatedJournalEntry);

        return updatedJournalEntry;
    }


//    method to work out which parameter updating


}
