package com.happenings.controller;


import com.happenings.entity.Event;
import com.happenings.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping
  public List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }

  @GetMapping("/{id}")
  public Event getEventById(@PathVariable int id) {
    return eventService.getEventById(id);
  }

  @PostMapping
  public Event createEvent(@RequestBody Event event) {
    return eventService.createEvent(event);
  }

  @PutMapping("/{id}")
  public Event updateEvent(@PathVariable int id, @RequestBody Event event) {
    return eventService.updateEvent(id, event);
  }

  @DeleteMapping("/{id}")
  public void deleteEvent(@PathVariable int id) {
    eventService.deleteEvent(id);
  }
}
