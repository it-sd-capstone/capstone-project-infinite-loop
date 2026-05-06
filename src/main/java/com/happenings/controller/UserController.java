package com.happenings.controller;

import com.happenings.dto.UserResponse;
import com.happenings.entity.User;
import com.happenings.mapper.UserMapper;
import com.happenings.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;

  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping("/{id}")
  public UserResponse findById(@PathVariable Integer id) {
    User user = userService.findById(id);
    return userMapper.toResponse(user);   // ✔ FIXED — instance call
  }

  @PutMapping("/{id}")
  public UserResponse updateProfile(
          @PathVariable Integer id,
          @RequestBody User updated
  ) {
    User saved = userService.updateProfile(id, updated);
    return userMapper.toResponse(saved);   // ✔ FIXED — instance call
  }
}
