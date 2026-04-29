package com.happenings.controller;

import com.happenings.entity.Event;
import com.happenings.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping
  public List<Event> getAll() {
    return eventService.getAll();
  }

  @GetMapping("/{id}")
  public Event getById(@PathVariable Integer id) {
    return eventService.getById(id).orElse(null);
  }

  @PostMapping
  public Event create(@RequestBody Event event) {
    return eventService.create(event);
  }

  @PutMapping("/{id}")
  public Event update(@PathVariable Integer id, @RequestBody Event event) {
    event.setEventId(id);
    return eventService.update(event);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    eventService.delete(id);
  }
}
