package com.happenings.controller;

import com.happenings.dto.LoginRequest;
import com.happenings.dto.RegisterRequest;
import com.happenings.dto.UserResponse;
import com.happenings.entity.User;
import com.happenings.mapper.UserMapper;
import com.happenings.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("//api/auth")
public class AuthController {

  private final UserService userService;
  private final UserMapper userMapper;

  public AuthController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @PostMapping("/register")
  public UserResponse register(@RequestBody RegisterRequest request) {

    User user = userMapper.toEntity(request);

    User saved = userService.registerUser(
            user,
            request.getConfirmPassword()
    );

    return userMapper.toResponse(saved);
  }

  @PostMapping("/login")
  public UserResponse login(@RequestBody LoginRequest request) {
    User user = userService.loginUser(request.getEmail(), request.getPassword());
    return userMapper.toResponse(user);
  }
}
