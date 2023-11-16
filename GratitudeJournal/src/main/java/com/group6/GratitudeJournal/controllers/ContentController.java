package com.group6.GratitudeJournal.controllers;

import com.group6.GratitudeJournal.models.Content;
import com.group6.GratitudeJournal.models.ContentDTO;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<ContentDTO> addNewContent(@PathVariable long id, @RequestBody ContentDTO contentDTO){
        User foundUser = userService.getUserById(id);
        foundUser.
    }


}
