package com.happenings.controller;

import com.happenings.entity.Invitation;
import com.happenings.entity.User;
import com.happenings.services.InvitationService;
import com.happenings.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitations")
@CrossOrigin
public class InvitationController {

  private final InvitationService invitationService;
  private final UserService userService;

  public InvitationController(InvitationService invitationService, UserService userService) {
    this.invitationService = invitationService;
    this.userService = userService;
  }

  @PostMapping
  public Invitation send(@RequestBody Invitation invitation) {
    return invitationService.send(invitation);
  }

  @GetMapping("/received/{userId}")
  public List<Invitation> getReceived(@PathVariable Integer userId) {
    User user = userService.getById(userId).orElse(null);
    return invitationService.getReceived(user);
  }

  @GetMapping("/sent/{userId}")
  public List<Invitation> getSent(@PathVariable Integer userId) {
    User user = userService.getById(userId).orElse(null);
    return invitationService.getSent(user);
  }
}
