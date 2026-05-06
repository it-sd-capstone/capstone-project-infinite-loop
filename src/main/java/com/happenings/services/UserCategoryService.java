package com.happenings.services;

import com.happenings.entity.UserCategory;
import com.happenings.repository.UserCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    return repo.findByUser_Id(userId);
  }

  // GET Category names by user id
  public List<String> getCategoryNamesByUserId(Integer userId) {
    return repo.findByUser_Id(userId).stream()
            .map(uc -> uc.getCategory())
            .filter(Objects::nonNull)
            .map(category -> category.getCategoryName())
            .toList();
  }

  // GET ALL
  public List<UserCategory> getAll() {
    return repo.findAll();
  }
}