package com.happenings.repository;

import com.happenings.entity.SavedEvent;
import com.happenings.entity.SavedEventId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedEventRepository extends JpaRepository<SavedEvent, SavedEventId> {
  List<SavedEvent> findByUserId(Integer userId);
}
