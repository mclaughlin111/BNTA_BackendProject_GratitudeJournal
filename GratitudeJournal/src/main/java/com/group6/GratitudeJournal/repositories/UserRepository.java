package com.group6.GratitudeJournal.repositories;

import com.group6.GratitudeJournal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
