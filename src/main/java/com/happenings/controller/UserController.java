package com.happenings.controller;

import com.happenings.dto.UserResponse;
import com.happenings.dto.UserUpdateRequest;
import com.happenings.entity.User;
import com.happenings.mapper.UserMapper;
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
  public ResponseEntity<?> getUser(@PathVariable Integer id) {
    User user = userService.getById(id);
    UserResponse dto = UserMapper.toResponse(user);
    return ResponseEntity.ok(dto);
  }

  // UPDATE PROFILE
  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(
          @PathVariable Integer id,
          @RequestBody UserUpdateRequest req) {

    User updated = new User();
    updated.setUsername(req.getUsername());
    updated.setEmail(req.getEmail());
    updated.setName(req.getName());
    updated.setPassword(req.getPassword());

    User saved = userService.updateProfile(id, updated);
    UserResponse dto = UserMapper.toResponse(saved);

    return ResponseEntity.ok(dto);
  }
}
