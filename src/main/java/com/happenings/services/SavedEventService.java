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

  // SAVE EVENT
  public SavedEventResponse save(SavedEventRequest request) {

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

  // DELETE
  public boolean deleteById(Integer id) {
    if (savedRepo.existsById(id)) {
      savedRepo.deleteById(id);
      return true;
    }
    return false;
  }

  // GET BY USER
  public List<SavedEventResponse> getByUserId(Integer userId) {
    return savedRepo.findByUser_Id(userId)
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
  }

  // MAPPER
  private SavedEventResponse mapToResponse(SavedEvent saved) {
    SavedEventResponse res = new SavedEventResponse();
    res.setSavedEventId(saved.getSavedEventId());
    res.setUserId(saved.getUser().getId());
    res.setEventId(saved.getEvent().getEventId());
    return res;
  }
}