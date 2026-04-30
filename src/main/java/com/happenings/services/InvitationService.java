package com.happenings.services;

import com.happenings.services.EmailService;
import com.happenings.dto.InviteRequest;
import org.springframework.stereotype.Service;
@Service
public class InvitationService {

    private final EmailService emailService;

    public InvitationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendInvite(InviteRequest request) {

        emailService.sendInviteEmail(
                request.getEmail(),
                "Event ID: " + request.getEventId()
        );
        
    }
}
