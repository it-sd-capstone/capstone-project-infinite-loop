package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // GET USER BY ID
  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getById(id));
  }
}