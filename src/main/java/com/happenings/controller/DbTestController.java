package com.happenings.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller to test database connectivity.
 */
@RestController
@RequestMapping("/api")
public class DbTestController {

  private final JdbcTemplate jdbcTemplate;

  public DbTestController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // -------------------------
  // DATABASE HEALTH CHECK
  // -------------------------
  @GetMapping("/db-test")
  public ResponseEntity<String> testDb() {
    try {
      // Simple test query
      jdbcTemplate.execute("SELECT 1");
      return ResponseEntity.ok("Database connection successful!");
    } catch (Exception e) {
      return ResponseEntity.status(500)
              .body("Database connection FAILED: " + e.getMessage());
    }
  }
}