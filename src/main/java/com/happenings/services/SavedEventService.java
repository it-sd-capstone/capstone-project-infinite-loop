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

  public SavedEvent save(SavedEvent savedEvent) {
    return repo.save(savedEvent);
  }

  public void deleteById(Integer id) {
    repo.deleteById(id);
  }

  public List<SavedEvent> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }

  public List<SavedEvent> getAll() {
    return repo.findAll();
  }


  public void remove(Integer id) {
    repo.deleteById(id);
  }
}