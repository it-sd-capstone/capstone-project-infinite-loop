package com.happenings.services;

import com.happenings.entity.SavedEvent;
import com.happenings.entity.SavedEventId;
import com.happenings.repository.SavedEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedEventService {

  private final SavedEventRepository repo;

  public SavedEventService(SavedEventRepository repo) {
    this.repo = repo;
  }

  public SavedEvent save(SavedEvent savedEvent) {
    return repo.save(savedEvent);
  }

  public void remove(Integer userId, Integer eventId) {
    SavedEventId id = new SavedEventId();
    id.setUserId(userId);
    id.setEventId(eventId);

    repo.deleteById(id);
  }

  public List<SavedEvent> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }
}
