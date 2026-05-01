package com.happenings.services;

import com.happenings.entity.SavedEvent;
import com.happenings.repository.SavedEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedEventService {

  private final SavedEventRepository repo;

  public SavedEventService(SavedEventRepository repo) {
    this.repo = repo;
  }

  // SAVE EVENT
  public SavedEvent save(SavedEvent savedEvent) {
    return repo.save(savedEvent);
  }

  // DELETE EVENT (FIXED → returns boolean)
  public boolean deleteById(Integer id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }

  // GET BY USER
  public List<SavedEvent> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }

  // GET ALL
  public List<SavedEvent> getAll() {
    return repo.findAll();
  }
}