package com.happenings.controller;

import com.happenings.entity.Event;
import com.happenings.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

  private final EventService eventService;

  // -------------------------
  // CONSTRUCTOR INJECTION
  // -------------------------
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  // -------------------------
  // GET ALL EVENTS
  // -------------------------
  @GetMapping
  public ResponseEntity<List<Event>> getAllEvents() {
    List<Event> events = eventService.getAllEvents();
    return ResponseEntity.ok(events);
  }

  // -------------------------
  // GET EVENT BY ID
  // -------------------------
  @GetMapping("/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable int id) {

    Event event = eventService.getEventById(id);

    if (event == null) {
      return ResponseEntity.status(404).build();
    }

    return ResponseEntity.ok(event);
  }

  // -------------------------
  // CREATE EVENT
  // -------------------------
  @PostMapping
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {

    Event created = eventService.createEvent(event);

    return ResponseEntity.ok(created);
  }

  // -------------------------
  // UPDATE EVENT
  // -------------------------
  @PutMapping("/{id}")
  public ResponseEntity<Event> updateEvent(@PathVariable int id,
                                           @RequestBody Event event) {

    Event updated = eventService.updateEvent(id, event);

    if (updated == null) {
      return ResponseEntity.status(404).build();
    }

    return ResponseEntity.ok(updated);
  }

  // -------------------------
  // DELETE EVENT
  // -------------------------
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEvent(@PathVariable int id) {

    boolean deleted = eventService.deleteEvent(id);

    if (!deleted) {
      return ResponseEntity.status(404)
              .body("Event not found");
    }

    return ResponseEntity.ok("Event deleted successfully");
  }
}