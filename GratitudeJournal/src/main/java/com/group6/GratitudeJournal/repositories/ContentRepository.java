package com.group6.GratitudeJournal.repositories;

import com.group6.GratitudeJournal.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
