package com.group6.GratitudeJournal.services;

import com.group6.GratitudeJournal.models.Content;
import com.group6.GratitudeJournal.models.ContentDTO;
import com.group6.GratitudeJournal.models.EntryDTO;
import com.group6.GratitudeJournal.models.JournalEntry;
import com.group6.GratitudeJournal.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    EntryDTO entryDTO;

    @Autowired
    JournalEntryService journalEntryService;

    // add content - will write string to content class

    public void addContent(Long id, ContentDTO contentDTO){
        JournalEntry journalEntry = journalEntryService.findEntryById(id);
        String contentToAdd = contentDTO.getContent();
        Content contentToAdd = contentToAdd.
        content.addContent(ContentDTO);
        journalEntry.addContent();
    }

}
