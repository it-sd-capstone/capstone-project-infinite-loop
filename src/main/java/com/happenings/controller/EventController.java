package com.happenings.controller;

import com.happenings.dto.EventRequest;
import com.happenings.entity.Event;
import com.happenings.entity.User;
import com.happenings.security.JwtUtil;
import com.happenings.services.EventService;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

  private final EventService eventService;
  private final JwtUtil jwtUtil;
  private final UserService userService;

  public EventController(EventService eventService,
                         JwtUtil jwtUtil,
                         UserService userService ) {
    this.eventService = eventService;
    this.jwtUtil = jwtUtil;
    this.userService = userService;
  }

  // GET ALL EVENTS
  @GetMapping
  public ResponseEntity<List<Event>> getAllEvents() {
    return ResponseEntity.ok(eventService.getAllEvents());
  }

  // GET EVENT BY ID
  @GetMapping("/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable Integer id) {

    Event event = eventService.getEventById(id);

    if (event == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(event);
  }

  // CREATE EVENT
  @PostMapping
  public ResponseEntity<Event> createEvent(
          @RequestHeader("Authorization") String authHeader,
          @RequestBody EventRequest req
  ) {
    String token = authHeader.substring(7);

    // JWT contains email
    String email = jwtUtil.extractUsername(token);

    // Safe Optional handling
    User user = userService.getByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // attach logged-in user
    req.setCreatedByUserId(user.getId());

    Event created = eventService.createEvent(req);

    return ResponseEntity.ok(created);
  }

  // UPDATE EVENT
  @PutMapping("/{id}")
  public ResponseEntity<Event> updateEvent(@PathVariable Integer id,
                                           @RequestBody Event event) {

    Event updated = eventService.updateEvent(id, event);

    if (updated == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(updated);
  }

  // DELETE EVENT
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {

    boolean deleted = eventService.deleteEvent(id);

    if (!deleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }
}