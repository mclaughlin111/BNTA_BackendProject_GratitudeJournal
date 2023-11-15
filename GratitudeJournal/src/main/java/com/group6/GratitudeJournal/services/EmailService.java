package com.group6.GratitudeJournal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String address, String subject, String body){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("tmclaughlin5.1111@gmail.com");
        email.setTo(address);
        email.setText(body);
        email.setSubject(subject);

        mailSender.send(email);

        System.out.println("EMAIL SENT SUCCESSFULLY");

    }
}
