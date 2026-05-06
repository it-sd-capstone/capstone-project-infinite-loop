package com.happenings.services;

import com.happenings.dto.InviteEmailData;
import com.happenings.entity.Event;
import com.happenings.entity.Location;
import com.happenings.entity.User;
import com.happenings.services.EmailService;
import com.happenings.dto.InviteRequest;
import org.springframework.stereotype.Service;
@Service
public class InvitationService {

    private final EmailService emailService;
    private final LocationService locationService;
    private final UserService userService;

    public InvitationService(EmailService emailService,
                             LocationService locationService,
                             UserService userService) {
        this.emailService = emailService;
        this.locationService = locationService;
        this.userService = userService;
    }

    public void sendInvite(User sender, Event event, String recipientEmail) {

        User recipient = userService.getByEmail(recipientEmail)
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        Location location = locationService.getById(event.getLocationId());

        String locationText =
                location.getVenueName() + ", " +
                        location.getAddress() + ", " +
                        location.getCity() + ", " +
                        location.getState();

        InviteEmailData email = new InviteEmailData();

        email.setToEmail(recipientEmail);
        email.setRecipientUsername(recipient.getUsername());
        email.setSenderUsername(sender.getUsername());
        email.setEventTitle(event.getTitle());
        email.setEventDescription(event.getDescription());
        email.setEventDateTime(event.getEventDatetime().toString());
        email.setEventLocation(locationText);

        emailService.sendInviteEmail(email);
    }
}