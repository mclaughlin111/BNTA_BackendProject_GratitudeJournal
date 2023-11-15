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

        User user = new User("Billie", "billieredwood@gmail.com");
        userRepository.save(user);
        User user2 = new User("Tom", "mail@tommcl.co.uk");
        userRepository.save(user2);
        User user3 = new User("Mehlia","mehliarahman@gmail.com");
        userRepository.save(user3);
        User user4 = new User("Joe","joecarpentieri1@gmail.com");
        userRepository.save(user4);
        User user5 = new User("Rashad","rashad.ramali@hotmail.co.uk");
        userRepository.save(user5);
        //does this method need to be in the service?

        JournalEntry journalEntry1 = new JournalEntry(user, "I had a great day today", WeekDay.FRIDAY, MoodRating.REALLYGOOD);
        journalEntryRepository.save(journalEntry1);

        JournalEntry journalEntry2 = new JournalEntry(user2, "I had bad day", WeekDay.TUESDAY, MoodRating.REALLYBAD);
        journalEntryRepository.save(journalEntry2);

        JournalEntry journalEntry3 = new JournalEntry(user2, "I had a good day", WeekDay.THURSDAY, MoodRating.POSITIVE);
        journalEntryRepository.save(journalEntry3);

        JournalEntry journalEntry4 = new JournalEntry(user3, "I had an average day", WeekDay.SUNDAY, MoodRating.INDIFFERENT);
        journalEntryRepository.save(journalEntry4);

        JournalEntry journalEntry5 = new JournalEntry(user4, "I had a mediocre day", WeekDay.MONDAY, MoodRating.NEGATIVE);
        journalEntryRepository.save(journalEntry5);

        JournalEntry journalEntry6 = new JournalEntry(user4, "I had a brilliant", WeekDay.FRIDAY, MoodRating.REALLYGOOD);
        journalEntryRepository.save(journalEntry6);






    }

}
