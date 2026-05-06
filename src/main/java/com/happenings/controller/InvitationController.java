package com.happenings.controller;

import com.happenings.dto.InviteRequest;
import com.happenings.entity.Event;
import com.happenings.entity.User;
import com.happenings.security.JwtUtil;
import com.happenings.services.EventService;
import com.happenings.services.InvitationService;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invitations")
@CrossOrigin
public class InvitationController {

    private final InvitationService invitationService;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final EventService eventService;

    public InvitationController(
            InvitationService invitationService,
            JwtUtil jwtUtil,
            UserService userService,
            EventService eventService
    ) {
        this.invitationService = invitationService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.eventService = eventService;
    }

    @PostMapping("/invite")
    public ResponseEntity<?> sendInvite(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody InviteRequest req
    ) {

        String username = jwtUtil.extractUsername(authHeader.substring(7));
        User sender = userService.getByUsername(username);

        Event event = eventService.getById(req.getEventId());

        invitationService.sendInvite(sender, event, req.getEmail());

        return ResponseEntity.ok("Invite sent");
    }
}