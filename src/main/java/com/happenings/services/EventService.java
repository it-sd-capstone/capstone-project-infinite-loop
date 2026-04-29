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

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  public Event getEventById(int id) {
    return eventRepository.findById(id).orElse(null);
  }

  public Event createEvent(Event event) {
    return eventRepository.save(event);
  }

  public Event updateEvent(int id, Event updatedEvent) {
    Event existing = eventRepository.findById(id).orElse(null);
    if (existing == null) {
      return null;
    }

    existing.setTitle(updatedEvent.getTitle());
    existing.setDescription(updatedEvent.getDescription());
    existing.setLocation(updatedEvent.getLocation());
    existing.setCategory(updatedEvent.getCategory());
    existing.setEventDatetime(updatedEvent.getEventDatetime());
    // ^ This replaces setDate() + setTime()

    return eventRepository.save(existing);
  }

  public void deleteEvent(int id) {
    eventRepository.deleteById(id);
  }
}
