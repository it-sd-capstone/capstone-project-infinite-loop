package com.happenings.controller;

import com.happenings.dto.LoginRequest;
import com.happenings.dto.RegisterRequest;
import com.happenings.dto.UserResponse;
import com.happenings.entity.User;
import com.happenings.mapper.UserMapper;
import com.happenings.security.JwtUtil;
import com.happenings.services.UserService;
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

  // REGISTER USER
  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody RegisterRequest req) {

    User user = new User();
    user.setUsername(req.getUsername());
    user.setEmail(req.getEmail());
    user.setPassword(req.getPassword());
    user.setName(req.getName());

    User created = userService.registerUser(user);
    UserResponse dto = UserMapper.toResponse(created);

    return ResponseEntity.ok(dto);
  }

  // LOGIN USER
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody LoginRequest req) {

    User user = userService.loginUser(req.getEmail(), req.getPassword());

    if (user == null) {
      return ResponseEntity.status(401).body("Invalid credentials");
    }

    String token = jwtUtil.generateToken(req.getEmail());
    UserResponse dto = UserMapper.toResponse(user);

    return ResponseEntity.ok(Map.of(
            "token", token,
            "user", dto
    ));
  }
}
