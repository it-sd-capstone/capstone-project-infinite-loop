package com.happenings.controller;

import com.happenings.entity.Event;
import com.happenings.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class UserEventController {

    private final EventService eventService;

    public UserEventController(EventService eventService) {
        this.eventService = eventService;
    }

    // CREATE EVENT
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // UPDATE EVENT
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Integer id,
                             @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // DELETE EVENT
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        boolean deleted = eventService.deleteEvent(id);

        return deleted ? "Event deleted successfully" : "Event not found";
    }

    // GET EVENTS BY USER
    @GetMapping("/user/{userId}")
    public List<Event> getEventsByUser(@PathVariable Integer userId) {
        return eventService.getEventsByUser(userId);
    }

    // GET ALL EVENTS
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}