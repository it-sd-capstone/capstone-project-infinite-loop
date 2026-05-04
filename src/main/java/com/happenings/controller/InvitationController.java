package com.happenings.controller;

import com.happenings.dto.InviteRequest;
import com.happenings.services.InvitationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invitations")
@CrossOrigin
public class InvitationController {

    private final InvitationService invitationService;

    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping
    public String send(@RequestBody InviteRequest request) {
        invitationService.sendInvitation(request);
        return "Invite sent";
    }
}