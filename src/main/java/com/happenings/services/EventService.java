package com.happenings.services;

import com.happenings.entity.Event;
import com.happenings.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  public List<Event> getAll() {
    return eventRepository.findAll();
  }

  public Optional<Event> getById(Integer id) {
    return eventRepository.findById(id);
  }

  public Event create(Event event) {
    return eventRepository.save(event);
  }

  public Event update(Event event) {
    return eventRepository.save(event);
  }

  public void delete(Integer id) {
    eventRepository.deleteById(id);
  }

  public List<Event> searchByTitle(String title) {
    return eventRepository.findByTitleContaining(title);
  }
}
