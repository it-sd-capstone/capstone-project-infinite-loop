package com.happenings.services;

import com.happenings.entity.UserCategory;
import com.happenings.repository.UserCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCategoryService {

  private final UserCategoryRepository repo;

  public UserCategoryService(UserCategoryRepository repo) {
    this.repo = repo;
  }

  // SAVE / ASSIGN CATEGORY
  public UserCategory save(UserCategory userCategory) {
    return repo.save(userCategory);
  }

  // DELETE (FIXED → returns boolean)
  public boolean deleteById(Integer id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }

  // GET BY USER ID
  public List<UserCategory> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }

  // GET ALL
  public List<UserCategory> getAll() {
    return repo.findAll();
  }
}