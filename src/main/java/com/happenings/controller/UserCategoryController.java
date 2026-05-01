package com.happenings.controller;

import com.happenings.entity.UserCategory;
import com.happenings.services.UserCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-categories")
@CrossOrigin(origins = "*")
public class UserCategoryController {

  private final UserCategoryService userCategoryService;

  public UserCategoryController(UserCategoryService userCategoryService) {
    this.userCategoryService = userCategoryService;
  }

  // -------------------------
  // ASSIGN CATEGORY TO USER
  // -------------------------
  @PostMapping
  public ResponseEntity<?> assignCategory(@RequestBody UserCategory userCategory) {

    if (userCategory == null) {
      return ResponseEntity.badRequest()
              .body("UserCategory request body is required");
    }

    UserCategory saved = userCategoryService.save(userCategory);
    return ResponseEntity.ok(saved);
  }

  // -------------------------
  // REMOVE USER CATEGORY BY ID
  // -------------------------
  @DeleteMapping("/{id}")
  public ResponseEntity<?> removeUserCategory(@PathVariable Integer id) {

    boolean deleted = userCategoryService.deleteById(id);

    if (!deleted) {
      return ResponseEntity.status(404)
              .body("UserCategory not found with id: " + id);
    }

    return ResponseEntity.ok("User category removed successfully");
  }
}