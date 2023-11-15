package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.services.EmailService;
import com.group6.GratitudeJournal.services.QuoteService;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    QuoteService quoteService;
    @Autowired
    UserService userService;

    @Autowired
    private EmailService emailService;

//send quote to user by email
    @GetMapping(value = "/{id}")
    public ResponseEntity<String> sendQuoteToUserByEmail(@PathVariable long id){
        User userToContact = userService.getUserById(id);
        String quote = quoteService.getRandomQuote();
        emailService.sendEmail(userToContact.getEmailAddress(), "⭐️ Motivational Quote For Today Is: ", quote);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }
}
