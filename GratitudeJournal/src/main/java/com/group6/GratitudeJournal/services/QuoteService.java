package com.group6.GratitudeJournal.services;

import com.group6.GratitudeJournal.models.Quote;
import org.springframework.stereotype.Service;
@Service
public class QuoteService {
    public String getRandomQuote(){
        Quote randomQuote = new Quote();
        return randomQuote.getRandomQuote();
    }
}
