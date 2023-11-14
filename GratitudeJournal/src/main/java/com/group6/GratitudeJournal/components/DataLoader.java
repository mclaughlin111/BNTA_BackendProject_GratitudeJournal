package com.group6.GratitudeJournal.components;

import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.models.MoodRating;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.models.WeekDay;
import com.group6.GratitudeJournal.repositories.JournalEntryRepository;
import com.group6.GratitudeJournal.repositories.UserRepository;
import com.group6.GratitudeJournal.services.JournalEntryService;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserService userService;
    @Autowired
    JournalEntryService journalEntryService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JournalEntryRepository journalEntryRepository;

//    public DataLoader(){        //checked whether this was required; it's not.
//

    @Override
    public void run(ApplicationArguments args) throws Exception {   //check why we use this?

        User user = new User("Billie", "billie@bnta.com");
        userRepository.save(user);
        //does this method need to be in the service?

        JournalEntry journalEntry = new JournalEntry(user, "I had a great day today", WeekDay.FRIDAY, MoodRating.REALLYGOOD);
        journalEntryRepository.save(journalEntry);
    }

}
