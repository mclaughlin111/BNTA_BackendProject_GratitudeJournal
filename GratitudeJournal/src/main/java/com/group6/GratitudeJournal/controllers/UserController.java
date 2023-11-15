package com.group6.GratitudeJournal.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group6.GratitudeJournal.models.User;
import com.group6.GratitudeJournal.models.UserDTO;
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

//    create a user - tested ✅
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    update a user - tested ✅
    @PatchMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO){
        User updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //delete a user - tested ✅
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
