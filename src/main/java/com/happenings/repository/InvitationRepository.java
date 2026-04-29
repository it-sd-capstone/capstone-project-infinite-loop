package com.happenings.repository;
import com.happenings.entity.Invitation;
import com.happenings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {
  List<Invitation> findByReceiver(User receiver);
  List<Invitation> findBySender(User sender);
}
