package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import com.happenings.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

  // ============================
  // REGISTER
  // ============================
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {
    User created = userService.register(user);
    return ResponseEntity.ok(created);
  }

  // ============================
  // LOGIN
  // ============================
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> body) {

    String email = body.get("email");
    String password = body.get("password");

    User user = userService.login(email, password);

    if (user == null) {
      return ResponseEntity.status(401).body("Invalid credentials");
    }

    String token = jwtUtil.generateToken(email);

    return ResponseEntity.ok(Map.of(
            "token", token,
            "user", user
    ));
  }
}
