package com.happenings.controller;

import com.happenings.dto.SavedEventRequest;
import com.happenings.dto.SavedEventResponse;
import com.happenings.services.SavedEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved-events") // ✅ consistent naming
@CrossOrigin(origins = "*")
public class SavedEventController {

  private final SavedEventService service;

  public SavedEventController(SavedEventService service) {
    this.service = service;
  }

  // ✅ SAVE
  @PostMapping
  public ResponseEntity<SavedEventResponse> save(@RequestBody SavedEventRequest request) {
    return ResponseEntity.ok(service.save(request));
  }

  // ✅ DELETE (FIXED)
  @DeleteMapping
  public ResponseEntity<String> delete(
          @RequestParam Integer userId,
          @RequestParam Integer eventId) {

    boolean deleted = service.deleteByUserAndEvent(userId, eventId);

    if (!deleted) {
      return ResponseEntity.status(404).body("Not found");
    }

    return ResponseEntity.ok("Deleted");
  }

  // ✅ GET BY USER
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<SavedEventResponse>> getByUser(@PathVariable Integer userId) {
    return ResponseEntity.ok(service.getByUserId(userId));
  }
}