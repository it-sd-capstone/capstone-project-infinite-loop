package com.happenings.services;

import com.happenings.entity.Category;
import com.happenings.entity.User;
import com.happenings.entity.UserCategory;
import com.happenings.repository.CategoryRepository;
import com.happenings.repository.UserCategoryRepository;
import com.happenings.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repo;
  private final PasswordEncoder passwordEncoder;
  private final CategoryRepository categoryRepo;
  private final UserCategoryRepository userCategoryRepo;

  public UserService(UserRepository repo, PasswordEncoder passwordEncoder, CategoryRepository categoryRepo,
                     UserCategoryRepository userCategoryRepo) {
    this.repo = repo;
    this.passwordEncoder = passwordEncoder;
    this.categoryRepo = categoryRepo;
    this.userCategoryRepo = userCategoryRepo;

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
  public User register(User user, List<String> categories) {

    // validate
    if (user.getEmail() == null ||
            user.getPassword() == null ||
            user.getUsername() == null) {
      throw new RuntimeException("Missing required fields");
    }

    if (repo.existsByEmail(user.getEmail())) {
      throw new RuntimeException("Email already in use");
    }

    if (repo.existsByUsername(user.getUsername())) {
      throw new RuntimeException("Username already in use");
    }

    // encode password
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    // default role
    if (user.getRole() == null) {
      user.setRole("USER");
    }

    // save user first
    User savedUser = repo.save(user);

    if (categories != null) {
      for (String catName : categories) {

        Category category = categoryRepo
                .findByCategoryName(catName)
                .orElseThrow(() -> new RuntimeException("Category not found: " + catName));

        UserCategory uc = new UserCategory();
        uc.setUser(savedUser);
        uc.setCategory(category);

        userCategoryRepo.save(uc);
      }
    }

    return savedUser;
  }

  // LOGIN USER
  public User loginByUsername(String username, String rawPassword) {

    Optional<User> optionalUser = repo.findByUsername(username);

    if (optionalUser.isEmpty()) {
      return null;
    }

    User user = optionalUser.get();

    System.out.println("LOGIN ATTEMPT: " + username);
    System.out.println("DB USER: " + user.getUsername());
    System.out.println("DB PASSWORD HASH: " + user.getPassword());
    System.out.println("PASSWORD MATCH: " + passwordEncoder.matches(rawPassword, user.getPassword()));

    if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
      return null;
    }

    return user;
  }

  // UPDATE PROFILE
  public User updateProfile(Integer id, User updated) {
    User existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // Update allowed fields
    if (updated.getUsername() != null) {
      existing.setUsername(updated.getUsername());
    }

    if (updated.getEmail() != null) {
      existing.setEmail(updated.getEmail());
    }

    // If password is being changed
    if (updated.getPassword() != null && !updated.getPassword().isBlank()) {
      existing.setPassword(passwordEncoder.encode(updated.getPassword()));
    }

    return repo.save(existing);
  }

  // GET BY USERNAME
  public User getByUsername(String username) {
    return repo.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
  }
}
