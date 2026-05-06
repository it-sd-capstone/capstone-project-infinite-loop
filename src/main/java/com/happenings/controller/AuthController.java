package com.happenings.controller;

import com.happenings.dto.LoginRequest;
import com.happenings.dto.RegisterRequest;
import com.happenings.dto.UserResponse;
import com.happenings.entity.User;
import com.happenings.mapper.UserMapper;
import com.happenings.security.JwtUtil;
import com.happenings.services.UserService;
import jakarta.annotation.PostConstruct;
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

  // REGISTER
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

    User user = new User();
    user.setUsername(req.getUsername());
    user.setEmail(req.getEmail());
    user.setPassword(req.getPassword());

    User created = userService.register(user, req.getCategories());

    return ResponseEntity.ok(UserMapper.toResponse(created));
  }

  // LOGIN
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest req) {
    System.out.println("LOGIN CONTROLLER HIT");
    User user = userService.loginByUsername(req.getUsername(), req.getPassword());

    if (user == null) {
      return ResponseEntity.status(401).body("Invalid credentials");
    }

    String token = jwtUtil.generateToken(user.getUsername());
    UserResponse dto = UserMapper.toResponse(user);

    return ResponseEntity.ok(Map.of(
            "token", token,
            "user", dto
    ));
  }
}
