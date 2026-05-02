package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  // REGISTER
  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user) {
    return ResponseEntity.ok(userService.register(user));
  }
}