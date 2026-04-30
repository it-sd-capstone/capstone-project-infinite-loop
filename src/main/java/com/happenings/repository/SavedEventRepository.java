package com.happenings.repository;

import com.happenings.entity.SavedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedEventRepository extends JpaRepository<SavedEvent, Integer> {
  List<SavedEvent> findByUserId(Integer userId);
}