package com.group6.GratitudeJournal.repositories;

import com.group6.GratitudeJournal.models.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}
