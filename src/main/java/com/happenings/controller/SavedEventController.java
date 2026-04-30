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

  @DeleteMapping("/{id}")
  public void remove(@PathVariable Integer id) {
    savedEventService.deleteById(id);
  }

  // Get all saved events for a specific user
  @GetMapping("/user/{userId}")
  public List<SavedEvent> getByUser(@PathVariable Integer userId) {
    return savedEventService.getByUserId(userId);
  }
}
