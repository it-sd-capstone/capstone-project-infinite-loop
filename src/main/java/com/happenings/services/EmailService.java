package com.happenings.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//    private final JavaMailSender mailSender;

//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    public void sendInviteEmail(String toEmail, String eventName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("You're invited!");
        message.setText("You’ve been invited to: " + eventName);

//        mailSender.send(message);
    }
}
