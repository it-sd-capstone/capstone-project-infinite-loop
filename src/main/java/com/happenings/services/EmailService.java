package com.happenings.services;

import com.happenings.dto.InviteEmailData;
import com.happenings.dto.InviteRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendInviteEmail(InviteEmailData req) {

        String body =
                "Hi " + req.getRecipientUsername() + ",\n\n" +
                        "You've been invited to an event through Happenings.\n\n" +
                        req.getSenderUsername() + " invited you to: " + req.getEventTitle() + "\n\n" +
                        "Event details:\n" +
                        "Description: " + req.getEventDescription() + "\n" +
                        "Date/Time: " + req.getEventDateTime() + "\n" +
                        "Location: " + req.getEventLocation() + "\n\n" +
                        "See you there!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(req.getToEmail());
        message.setSubject("You're invited to " + req.getEventTitle());
        message.setText(body);

        mailSender.send(message);
    }
}
