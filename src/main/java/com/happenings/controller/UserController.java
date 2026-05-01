package com.happenings.controller;

import com.happenings.entity.User;
import com.happenings.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    Optional<User> user = userService.findById(id);
    return user.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // UPDATE USER PROFILE
  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User updated) {
    User result = userService.updateProfile(id, updated);
    if (result == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(result);
  }
}
