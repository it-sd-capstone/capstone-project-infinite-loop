package com.happenings.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
  name = "user",
  uniqueConstraints = {@UniqueConstraint(columnNames = "email")}
)

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  private String role;

  @Column(name = "createdAt", updatable = false)
  private LocalDateTime createdAt;

  public User() {}

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {return role;}

  public void setRole(String role) {this.role = role;}

  public LocalDateTime getCreatedAt() {return createdAt;}

}
