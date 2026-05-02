package com.happenings.services;

import com.happenings.entity.User;
import com.happenings.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  // GET BY ID
  public User getById(Integer id) {
    return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
  }

  // GET BY EMAIL
  public Optional<User> getByEmail(String email) {
    return repo.findByEmail(email);
  }

  // REGISTER USER
  public User register(User user) {
    return repo.save(user);
  }
}