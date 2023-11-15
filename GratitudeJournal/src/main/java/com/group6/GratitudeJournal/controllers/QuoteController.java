package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

//  Get a random quote
    @GetMapping
    public ResponseEntity<String> getRandomQuote(){
        return new ResponseEntity<>(quoteService.getRandomQuote(), HttpStatus.OK);
    }
}
