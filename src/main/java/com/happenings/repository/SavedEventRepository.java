package com.happenings.repository;

import com.happenings.entity.SavedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SavedEventRepository extends JpaRepository<SavedEvent, Integer> {

  // check if user already saved event
  Optional<SavedEvent> findByUser_IdAndEvent_EventId(Integer userId, Integer eventId);

  // get all saved events for a user
  List<SavedEvent> findByUser_Id(Integer userId);
}