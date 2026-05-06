package com.happenings.services;

import com.happenings.entity.User;
import com.happenings.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserService userService;

    @Test
    void getById_shouldReturnUser() {
        User user = new User();
        user.setId(1);

        when(repo.findById(1)).thenReturn(Optional.of(user));

        User result = userService.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void getById_shouldThrowException_whenNotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());

        Exception ex = assertThrows(RuntimeException.class,
                () -> userService.findById(1));

        assertEquals("User not found", ex.getMessage());
    }

    @Test
    void register_shouldSaveUser() {
        User user = new User();
        user.setEmail("test@email.com");
        user.setUsername("testuser");
        user.setPassword("Password123!");

        when(repo.existsByEmail(user.getEmail())).thenReturn(false);
        when(repo.existsByUsername(user.getUsername())).thenReturn(false);
        when(repo.save(user)).thenReturn(user);

        User saved = userService.registerUser(
                user,
                "Password123!"      // confirmPassword
        );

        assertEquals("test@email.com", saved.getEmail());
        verify(repo).save(user);
    }


    @Test
    void getByEmail_shouldReturnOptional() {
        User user = new User();
        user.setEmail("test@email.com");

        when(repo.findByEmail("test@email.com"))
                .thenReturn(Optional.of(user));

        Optional<User> result = userService.findByEmail("test@email.com");

        assertTrue(result.isPresent());
    }
}