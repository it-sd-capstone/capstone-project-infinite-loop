package com.happenings.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class UserTest {

    @Test
    void prePersist_shouldSetCreatedAt() {
        User user = new User();

        user.setName("Test User");
        user.setEmail("test@email.com");
        user.setPassword("pass");

        user.onCreate(); // manually trigger lifecycle method

        assertNotNull(user.getCreatedAt());
    }

    @Test
    void settersAndGetters_shouldWork() {
        User user = new User();

        user.setId(1);
        user.setName("John");
        user.setEmail("john@email.com");
        user.setPassword("1234");
        user.setRole("USER");

        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("USER", user.getRole());
    }
}
