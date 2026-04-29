package com.happenings.services;


import com.happenings.entity.Invitation;
import com.happenings.entity.User;
import com.happenings.repository.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {

  private final InvitationRepository repo;

  public InvitationService(InvitationRepository repo) {
    this.repo = repo;
  }

  public Invitation send(Invitation invitation) {
    return repo.save(invitation);
  }

  public List<Invitation> getReceived(User user) {
    return repo.findByReceiver(user);
  }

  public List<Invitation> getSent(User user) {
    return repo.findBySender(user);
  }
}
