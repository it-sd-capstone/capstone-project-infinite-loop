package com.happenings.services;

import com.happenings.dto.EventRequest;
import com.happenings.entity.Event;
import com.happenings.entity.Location;
import com.happenings.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

  private final EventRepository eventRepository;
  private final LocationService locationService;


  public EventService(EventRepository eventRepository,
                      LocationService locationService) {
    this.eventRepository = eventRepository;
    this.locationService = locationService;
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
  public Event createEvent(EventRequest req) {

    Location location = locationService.findOrCreate(
            req.getVenueName(),
            req.getAddress(),
            req.getCity(),
            req.getState()
    );

    Event event = new Event();
    event.setTitle(req.getTitle());
    event.setDescription(req.getDescription());
    event.setEventDatetime(req.getEventDatetime());
    event.setCategoryId(req.getCategoryId());
    event.setCreatedByUserId(req.getCreatedByUserId());

    event.setLocation(location);

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
    existing.setLocation(updatedEvent.getLocation());
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

  //Gets the events by the user that created them
  public List<Event> getEventsByUser(Integer userId) {
    return eventRepository.findByCreatedByUserId(userId);
  }

  public Event getById(Integer id) {
    return eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));
  }
}