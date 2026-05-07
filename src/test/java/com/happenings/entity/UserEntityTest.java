package com.happenings.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void prePersist_shouldSetCreatedAt() {

        User user = new User();

        user.setUsername("Test User");
        user.setEmail("test@email.com");
        user.setPassword("pass");

        user.onCreate(); // manually trigger lifecycle method

        assertNotNull(user.getCreatedAt());
    }

    @Test
    void settersAndGetters_shouldWork() {

        User user = new User();

        user.setId(1);
        user.setUsername("John");
        user.setEmail("john@email.com");
        user.setPassword("1234");
        user.setRole("USER");

        assertEquals(1, user.getId());
        assertEquals("John", user.getUsername());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("USER", user.getRole());
    }
}