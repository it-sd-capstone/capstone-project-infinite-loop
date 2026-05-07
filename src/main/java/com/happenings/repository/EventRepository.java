package com.happenings.repository;

import com.happenings.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {

    // Get all events created by a user
    List<Event> findByCreatedByUserId(Integer userId);

    Optional<Event> findById(Integer id);

    // Recommendation queries
    List<Event> findByCategoryIdAndEventDatetimeAfterOrderByEventDatetimeAsc(
            Integer categoryId,
            LocalDateTime now
    );

    // Fallback query
    List<Event> findTop10ByEventDatetimeAfterOrderByEventDatetimeAsc(
            LocalDateTime now
    );
}