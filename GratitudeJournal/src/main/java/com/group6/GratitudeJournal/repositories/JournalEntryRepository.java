package com.group6.GratitudeJournal.repositories;

import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.models.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

    @Query
    List<JournalEntry> findByWeekDayAndUserId(WeekDay weekDay, long id);

}
