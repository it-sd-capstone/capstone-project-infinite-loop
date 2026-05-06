package com.happenings.services;

import com.happenings.entity.User;
import com.happenings.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repo;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
    this.repo = repo;
    this.passwordEncoder = passwordEncoder;
  }

  // FIND BY ID
  public User findById(Integer id) {
    return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
  }

  // FIND BY EMAIL
  public Optional<User> findByEmail(String email) {
    return repo.findByEmail(email);
  }

  // REGISTER USER
  public User registerUser(User user) {

    if (user.getEmail() == null || user.getPassword() == null ||
            user.getUsername() == null || user.getName() == null) {
      throw new RuntimeException("Missing required fields");
    }

    if (repo.existsByEmail(user.getEmail())) {
      throw new RuntimeException("Email already in use");
    }

    if (repo.existsByUsername(user.getUsername())) {
      throw new RuntimeException("Username already in use");
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    if (user.getRole() == null) {
      user.setRole("USER");
    }

    return repo.save(user);
  }

  // LOGIN USER
  public User loginUser(String email, String rawPassword) {
    Optional<User> optionalUser = repo.findByEmail(email);

    if (optionalUser.isEmpty()) {
      return null;
    }

    User user = optionalUser.get();

    if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
      return null;
    }

    return user;
  }

  // UPDATE PROFILE
  public User updateProfile(Integer id, User updated) {
    User existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (updated.getName() != null) {
      existing.setName(updated.getName());
    }

    if (updated.getUsername() != null) {
      existing.setUsername(updated.getUsername());
    }

    if (updated.getEmail() != null) {
      existing.setEmail(updated.getEmail());
    }

    if (updated.getPassword() != null && !updated.getPassword().isBlank()) {
      existing.setPassword(passwordEncoder.encode(updated.getPassword()));
    }

    return repo.save(existing);
  }
}
