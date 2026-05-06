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

  private final UserRepository userRepository;
  private final CategoryRepository categoryRepository;
  private final UserCategoryRepository userCategoryRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
                     CategoryRepository categoryRepository,
                     UserCategoryRepository userCategoryRepository,
                     PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.categoryRepository = categoryRepository;
    this.userCategoryRepository = userCategoryRepository;
    this.passwordEncoder = passwordEncoder;
  }

  // ------------------------------------------------------------
// REGISTER USER (categoryId optional)
// ------------------------------------------------------------
  public User registerUser(User user, String confirmPassword) {

    // Required fields
    if (user.getEmail() == null ||
            user.getPassword() == null ||
            user.getUsername() == null ||
            user.getName() == null) {
      throw new RuntimeException("Missing required fields");
    }

    // Password match check
    if (!user.getPassword().equals(confirmPassword)) {
      throw new RuntimeException("Passwords do not match");
    }

    // Duplicate checks
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new RuntimeException("Email already in use");
    }

    if (userRepository.existsByUsername(user.getUsername())) {
      throw new RuntimeException("Username already in use");
    }

    // Encode password
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    // Default role
    if (user.getRole() == null) {
      user.setRole("USER");
    }

    // Save user
    User savedUser = userRepository.save(user);

    // CategoryId is OPTIONAL now — do nothing if null or empty
    return savedUser;
  }


  // ------------------------------------------------------------
  // LOGIN USER
  // ------------------------------------------------------------
  public User loginUser(String email, String rawPassword) {

    Optional<User> optionalUser = userRepository.findByEmail(email);

    if (optionalUser.isEmpty()) {
      throw new RuntimeException("Invalid credentials");
    }

    User user = optionalUser.get();

    if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }

    return user;
  }

  // ------------------------------------------------------------
  // FIND BY EMAIL
  // ------------------------------------------------------------
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  // ------------------------------------------------------------
  // FIND BY ID
  // ------------------------------------------------------------
  public User findById(Integer id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  // ------------------------------------------------------------
  // UPDATE PROFILE
  // ------------------------------------------------------------
  public User updateProfile(Integer id, User updated) {

    User existing = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    existing.setUsername(updated.getUsername());
    existing.setEmail(updated.getEmail());
    existing.setName(updated.getName());

    if (updated.getPassword() != null && !updated.getPassword().isEmpty()) {
      existing.setPassword(passwordEncoder.encode(updated.getPassword()));
    }

    return userRepository.save(existing);
  }
}
