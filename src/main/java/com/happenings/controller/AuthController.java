package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  // -------------------------
  // LOGIN
  // -------------------------
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> body) {

    String email = body.get("email");
    String password = body.get("password");

    if (email == null || password == null) {
      return ResponseEntity.badRequest()
              .body("Email and password are required");
    }

    Optional<User> user = userService.login(email, password);

    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    } else {
      return ResponseEntity.status(401)
              .body("Invalid credentials");
    }
  }

  // -------------------------
  // REGISTER
  // -------------------------
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {

    if (user.getEmail() == null || user.getPassword() == null) {
      return ResponseEntity.badRequest()
              .body("Email and password required");
    }

    User createdUser = userService.register(user);
    return ResponseEntity.ok(createdUser);
  }
}
