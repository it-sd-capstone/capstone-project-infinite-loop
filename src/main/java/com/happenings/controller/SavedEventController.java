package com.happenings.controller;

import com.happenings.entity.SavedEvent;
import com.happenings.services.SavedEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved")
@CrossOrigin(origins = "*")
public class SavedEventController {

  private final SavedEventService savedEventService;

  public SavedEventController(SavedEventService savedEventService) {
    this.savedEventService = savedEventService;
  }

  // -------------------------
  // SAVE EVENT
  // -------------------------
  @PostMapping
  public ResponseEntity<SavedEvent> save(@RequestBody SavedEvent savedEvent) {

    SavedEvent created = savedEventService.save(savedEvent);

    return ResponseEntity.ok(created);
  }

  // -------------------------
  // DELETE SAVED EVENT
  // -------------------------
  @DeleteMapping("/{id}")
  public ResponseEntity<String> remove(@PathVariable Integer id) {

    boolean deleted = savedEventService.deleteById(id);

    if (!deleted) {
      return ResponseEntity.status(404)
              .body("Saved event not found");
    }

    return ResponseEntity.ok("Saved event removed successfully");
  }

  // -------------------------
  // GET SAVED EVENTS BY USER
  // -------------------------
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<SavedEvent>> getByUser(@PathVariable Integer userId) {

    List<SavedEvent> savedEvents = savedEventService.getByUserId(userId);

    return ResponseEntity.ok(savedEvents);
  }
}