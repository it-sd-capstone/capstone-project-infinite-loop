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

  //Register
  public User register(User user) {
    return repo.save(user);
  }

  //Login
  public Optional<User> login(String email, String password) {
    return repo.findByEmail(email)
            .filter(u -> u.getPassword().equals(password));
  }

  //Update Profile
  public User updateProfile(Integer id, User updated) {
    return repo.findById(id)
            .map(existing -> {
              existing.setName(updated.getName());
              existing.setEmail(updated.getEmail());
              existing.setRole(updated.getRole());
              return repo.save(existing);
            })
            .orElse(null);
  }

  public Optional<User> findById(Integer id) {
    return repo.findById(id);
  }

  public Optional<User> findByEmail(String email) {
    return repo.findByEmail(email);
  }
}
