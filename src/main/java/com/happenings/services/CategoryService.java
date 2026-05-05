package com.happenings.services;

import com.happenings.entity.Category;
import com.happenings.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  private final CategoryRepository repo;

  public CategoryService(CategoryRepository repo) {
    this.repo = repo;
  }

  // GET ALL
  public List<Category> getAll() {
    return repo.findAll();
  }

  // GET BY ID
  public Category getById(Integer id) {
    return repo.findById(id).orElse(null);
  }

  // CREATE
  public Category create(Category category) {
    return repo.save(category);
  }

  // UPDATE
  public Category update(Integer id, Category updated) {

    return repo.findById(id)
            .map(existing -> {
              existing.setCategoryName(updated.getCategoryName());
              return repo.save(existing);
            })
            .orElse(null);
  }

  // DELETE
  public boolean delete(Integer id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }
}