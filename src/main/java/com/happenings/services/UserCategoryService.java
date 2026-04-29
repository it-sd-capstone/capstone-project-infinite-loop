package com.happenings.services;

import com.happenings.entity.UserCategory;
import com.happenings.entity.UserCategoryId;
import com.happenings.repository.UserCategoryRepository;
import org.springframework.stereotype.Service;

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

  public void remove(Integer userId, Integer categoryId) {
    UserCategoryId id = new UserCategoryId();
    id.setUserId(userId);
    id.setCategoryId(categoryId);
    repo.deleteById(id);
  }

  public List<UserCategory> getByUserId(Integer userId) {
    return repo.findByUserId(userId);
  }
}
