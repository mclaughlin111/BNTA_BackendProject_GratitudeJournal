package com.group6.GratitudeJournal.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

//    GET all users
    @GetMapping  // - tested ✅
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //delete a user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
