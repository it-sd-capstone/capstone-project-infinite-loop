package com.happenings.controller;

import com.happenings.entity.Category;
import com.happenings.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  // GET ALL
  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    return ResponseEntity.ok(categoryService.getAll());
  }

  // GET BY ID
  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(@PathVariable Integer id) {

    Category category = categoryService.getById(id);

    if (category == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(category);
  }

  // CREATE
  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {
    return ResponseEntity.ok(categoryService.create(category));
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Category> update(@PathVariable Integer id,
                                         @RequestBody Category category) {

    Category updated = categoryService.update(id, category);

    if (updated == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(updated);
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {

    boolean deleted = categoryService.delete(id);

    if (!deleted) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
  }
}