package com.happenings.controller;

import com.happenings.entity.SavedEvent;
import com.happenings.services.SavedEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved")
@CrossOrigin
public class SavedEventController {

  private final SavedEventService savedEventService;

  public SavedEventController(SavedEventService savedEventService) {
    this.savedEventService = savedEventService;
  }

  // Save a new saved event
  @PostMapping
  public SavedEvent save(@RequestBody SavedEvent savedEvent) {
    return savedEventService.save(savedEvent);
  }

  // Remove a saved event using BOTH userId and eventId
  @DeleteMapping("/{userId}/{eventId}")
  public void remove(@PathVariable Integer userId, @PathVariable Integer eventId) {
    savedEventService.remove(userId, eventId);
  }

  // Get all saved events for a specific user
  @GetMapping("/user/{userId}")
  public List<SavedEvent> getByUser(@PathVariable Integer userId) {
    return savedEventService.getByUserId(userId);
  }
}
