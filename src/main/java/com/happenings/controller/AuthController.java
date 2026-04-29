package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public Object login(@RequestBody Map<String, String> body) {
    String email = body.get("email");
    String password = body.get("password");

    Optional<User> user = userService.login(email, password);

    return user.orElse(null);
  }

  @PostMapping("/register")
  public User register(@RequestBody User user) {
    return userService.register(user);
  }
}
