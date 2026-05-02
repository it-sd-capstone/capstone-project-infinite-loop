package com.happenings.services;

import com.happenings.entity.Event;
import com.happenings.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

  private final EventRepository eventRepository;

  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  // GET ALL EVENTS
  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  // GET EVENT BY ID
  public Event getEventById(Integer id) {
    return eventRepository.findById(id).orElse(null);
  }

  // CREATE EVENT
  public Event createEvent(Event event) {

    // optional validation
    if (event.getTitle() == null || event.getTitle().isBlank()) {
      throw new RuntimeException("Title is required");
    }

    return eventRepository.save(event);
  }

  // UPDATE EVENT
  public Event updateEvent(Integer id, Event updatedEvent) {

    Event existing = eventRepository.findById(id).orElse(null);

    if (existing == null) {
      return null;
    }

    existing.setTitle(updatedEvent.getTitle());
    existing.setDescription(updatedEvent.getDescription());
    existing.setEventDatetime(updatedEvent.getEventDatetime());
    existing.setLocationId(updatedEvent.getLocationId());
    existing.setCategoryId(updatedEvent.getCategoryId());

    return eventRepository.save(existing);
  }

  // DELETE EVENT
  public boolean deleteEvent(Integer id) {

    if (eventRepository.existsById(id)) {
      eventRepository.deleteById(id);
      return true;
    }

    return false;
  }
}