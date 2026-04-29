package com.happenings.controller;

import com.happenings.entity.UserCategory;
import com.happenings.services.UserCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-categories")
@CrossOrigin
public class UserCategoryController {

  private final UserCategoryService userCategoryService;

  public UserCategoryController(UserCategoryService userCategoryService) {
    this.userCategoryService = userCategoryService;
  }

  @PostMapping
  public UserCategory save(@RequestBody UserCategory userCategory) {
    return userCategoryService.save(userCategory);
  }

  @DeleteMapping("/{userId}/{categoryId}")
  public void remove(@PathVariable Integer userId, @PathVariable Integer categoryId) {
    userCategoryService.remove(userId, categoryId);
  }

  @GetMapping("/user/{userId}")
  public List<UserCategory> getByUser(@PathVariable Integer userId) {
    return userCategoryService.getByUserId(userId);
  }
}
