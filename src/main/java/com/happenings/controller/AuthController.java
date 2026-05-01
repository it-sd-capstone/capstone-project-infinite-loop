package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import com.happenings.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

  private final UserService userService;
  private final JwtUtil jwtUtil;

  public AuthController(UserService userService, JwtUtil jwtUtil) {
    this.userService = userService;
    this.jwtUtil = jwtUtil;
  }

  // REGISTER
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {

    if (user.getEmail() == null || user.getPassword() == null) {
      return ResponseEntity.badRequest()
              .body("Email and password required");
    }

    User createdUser = userService.register(user);
    return ResponseEntity.ok(createdUser);
  }

  // LOGIN (JWT)
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> body) {

    String email = body.get("email");
    String password = body.get("password");

    if (email == null || password == null) {
      return ResponseEntity.badRequest()
              .body("Email and password are required");
    }

    Optional<User> user = userService.login(email, password);

    if (user.isEmpty()) {
      return ResponseEntity.status(401).body("Invalid credentials");
    }

    String token = jwtUtil.generateToken(email);

    return ResponseEntity.ok(Map.of(
            "token", token,
            "user", user.get()
    ));
  }

  // LOGOUT (stateless)
  @PostMapping("/logout")
  public ResponseEntity<?> logout() {
    return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
  }
}
