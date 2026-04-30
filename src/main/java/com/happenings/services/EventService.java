package com.happenings.services;

import com.happenings.entity.Event;
import com.happenings.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  // GET ALL EVENTS
  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  // GET EVENT BY ID
  public Event getEventById(int id) {
    return eventRepository.findById(id).orElse(null);
  }

  // CREATE EVENT
  public Event createEvent(Event event) {
    return eventRepository.save(event);
  }

  // UPDATE EVENT (FIXED VERSION)
  public Event updateEvent(int id, Event updatedEvent) {
    Event existing = eventRepository.findById(id).orElse(null);

    if (existing == null) {
      return null;
    }

    existing.setTitle(updatedEvent.getTitle());
    existing.setDescription(updatedEvent.getDescription());
    existing.setEventDatetime(updatedEvent.getEventDatetime());

    // IMPORTANT: use FK IDs (not objects)
    existing.setLocationId(updatedEvent.getLocationId());
    existing.setCategoryId(updatedEvent.getCategoryId());

    return eventRepository.save(existing);
  }

  // DELETE EVENT
  public void deleteEvent(int id) {
    eventRepository.deleteById(id);
  }
}