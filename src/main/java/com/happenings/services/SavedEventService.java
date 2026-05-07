package com.happenings.services;

import com.happenings.dto.SavedEventRequest;
import com.happenings.dto.SavedEventResponse;
import com.happenings.entity.Event;
import com.happenings.entity.SavedEvent;
import com.happenings.entity.User;
import com.happenings.repository.EventRepository;
import com.happenings.repository.SavedEventRepository;
import com.happenings.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavedEventService {

  private final SavedEventRepository savedRepo;
  private final UserRepository userRepo;
  private final EventRepository eventRepo;

  public SavedEventService(SavedEventRepository savedRepo,
                           UserRepository userRepo,
                           EventRepository eventRepo) {
    this.savedRepo = savedRepo;
    this.userRepo = userRepo;
    this.eventRepo = eventRepo;
  }

  // ✅ SAVE EVENT (FIXED)
  public SavedEventResponse save(SavedEventRequest request) {

    if (request.getUserId() == null || request.getEventId() == null) {
      throw new RuntimeException("UserId and EventId are required");
    }

    // 🔥 prevent duplicate save (fixes crash)
    Optional<SavedEvent> existing =
            savedRepo.findByUser_IdAndEvent_EventId(
                    request.getUserId(),
                    request.getEventId()
            );

    if (existing.isPresent()) {
      return mapToResponse(existing.get());
    }

    User user = userRepo.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

    Event event = eventRepo.findById(request.getEventId())
            .orElseThrow(() -> new RuntimeException("Event not found"));

    SavedEvent savedEvent = new SavedEvent();
    savedEvent.setUser(user);
    savedEvent.setEvent(event);

    SavedEvent saved = savedRepo.save(savedEvent);

    return mapToResponse(saved);
  }

  // ✅ DELETE (NEW LOGIC)
  public boolean deleteByUserAndEvent(Integer userId, Integer eventId) {
    Optional<SavedEvent> existing =
            savedRepo.findByUser_IdAndEvent_EventId(userId, eventId);

    if (existing.isPresent()) {
      savedRepo.delete(existing.get());
      return true;
    }
    return false;
  }

  // ✅ GET BY USER
  public List<SavedEventResponse> getByUserId(Integer userId) {
    return savedRepo.findByUser_Id(userId)
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
  }

  // ✅ DTO MAPPER (FIXES FRONTEND DATA ISSUE)
  private SavedEventResponse mapToResponse(SavedEvent saved) {
    SavedEventResponse res = new SavedEventResponse();

    res.setSavedEventId(saved.getSavedEventId());
    res.setUserId(saved.getUser().getId());
    res.setEventId(saved.getEvent().getEventId());

    // 🔥 include event data so frontend works properly
    Event event = saved.getEvent();
    res.setTitle(event.getTitle());
    res.setDescription(event.getDescription());
    res.setEventDatetime(event.getEventDatetime());
    res.setLocation(event.getLocation());
    res.setCategoryId(event.getCategoryId());

    return res;
  }
}