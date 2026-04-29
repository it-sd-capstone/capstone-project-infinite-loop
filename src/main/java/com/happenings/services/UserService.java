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

  public Optional<User> login(String email, String password) {
    return repo.findByEmail(email)
            .filter(u -> u.getPassword().equals(password));
  }

  public User register(User user) {
    return repo.save(user);
  }

  public Optional<User> getById(Integer id) {
    return repo.findById(id);
  }

  public Optional<User> getByEmail(String email) {
    return repo.findByEmail(email);
  }
}
