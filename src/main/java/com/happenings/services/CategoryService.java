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

  public List<Category> getAll() {
    return repo.findAll();
  }
}
