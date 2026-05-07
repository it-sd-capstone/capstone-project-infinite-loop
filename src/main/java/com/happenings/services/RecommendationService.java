package com.happenings.services;

import com.happenings.entity.Event;
import com.happenings.entity.SavedEvent;
import com.happenings.repository.EventRepository;
import com.happenings.repository.SavedEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private SavedEventRepository savedEventRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getRecommendations(Integer userId) {

        LocalDateTime now = LocalDateTime.now();

        // Get saved events for user
        List<SavedEvent> savedEvents =
                savedEventRepository.findByUser_Id(userId);

        // FALLBACK: no saved events
        if (savedEvents == null || savedEvents.isEmpty()) {

            return eventRepository
                    .findTop10ByEventDatetimeAfterOrderByEventDatetimeAsc(now);
        }

        // Count category frequency
        Map<Integer, Integer> categoryCount = new HashMap<>();

        for (SavedEvent saved : savedEvents) {

            // Null protection
            if (saved == null ||
                    saved.getEvent() == null ||
                    saved.getEvent().getCategoryId() == null) {
                continue;
            }

            Integer categoryId =
                    saved.getEvent().getCategoryId();

            categoryCount.put(
                    categoryId,
                    categoryCount.getOrDefault(categoryId, 0) + 1
            );
        }

        // FALLBACK: no valid categories
        if (categoryCount.isEmpty()) {

            return eventRepository
                    .findTop10ByEventDatetimeAfterOrderByEventDatetimeAsc(now);
        }

        // Find most saved category
        Integer topCategoryId =
                Collections.max(
                        categoryCount.entrySet(),
                        Map.Entry.comparingByValue()
                ).getKey();

        // Get recommended events
        List<Event> recommendedEvents =
                eventRepository
                        .findByCategoryIdAndEventDatetimeAfterOrderByEventDatetimeAsc(
                                topCategoryId,
                                now
                        );

        // Remove already saved events
        Set<Integer> savedEventIds =
                savedEvents.stream()
                        .filter(saved -> saved.getEvent() != null)
                        .map(saved -> saved.getEvent().getEventId())
                        .collect(Collectors.toSet());

        recommendedEvents.removeIf(
                event -> savedEventIds.contains(event.getEventId())
        );

        // FINAL FALLBACK if recommendations empty
        if (recommendedEvents.isEmpty()) {

            return eventRepository
                    .findTop10ByEventDatetimeAfterOrderByEventDatetimeAsc(now);
        }

        return recommendedEvents;
    }
}