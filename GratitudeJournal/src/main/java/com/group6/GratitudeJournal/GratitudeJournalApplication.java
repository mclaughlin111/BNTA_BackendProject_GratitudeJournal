package com.group6.GratitudeJournal;

import com.group6.GratitudeJournal.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class GratitudeJournalApplication {

@Autowired
private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(GratitudeJournalApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
//		emailService.sendEmail("mail@tommcl.co.uk","Quote","Test");
	}

}
