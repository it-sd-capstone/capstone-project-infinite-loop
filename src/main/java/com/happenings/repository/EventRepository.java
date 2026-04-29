package com.happenings.repository;

import com.happenings.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
  List<Event> findByTitleContaining(String title);
}
