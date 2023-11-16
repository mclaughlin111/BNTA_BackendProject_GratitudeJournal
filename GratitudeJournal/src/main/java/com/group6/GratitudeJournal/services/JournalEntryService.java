package com.group6.GratitudeJournal.services;


import com.group6.GratitudeJournal.models.EntryDTO;
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
    public JournalEntry addNewJournalEntry(JournalEntry journalEntry) { //make it void?
        journalEntryRepository.save(journalEntry);
        return journalEntry;

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

//    dateTime method


}
