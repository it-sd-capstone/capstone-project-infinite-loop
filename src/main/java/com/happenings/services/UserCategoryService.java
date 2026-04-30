package com.happenings.services;

import com.happenings.entity.UserCategory;
import org.springframework.stereotype.Service;
import com.happenings.repository.UserCategoryRepository;

import java.util.List;

@Service
public class UserCategoryService {

  private final UserCategoryRepository repo;

  public UserCategoryService(UserCategoryRepository repo) {
    this.repo = repo;
  }

  public UserCategory save(UserCategory userCategory) {
    return repo.save(userCategory);
  }

  public void deleteById(Integer id) {
    repo.deleteById(id);
  }

  public List<UserCategory> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }

  public List<UserCategory> getAll() {
    return repo.findAll();
  }

  public void remove(Integer id) {
    repo.deleteById(id);
  }
}