package com.happenings.services;

import com.happenings.entity.User;
import com.happenings.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        User result = userService.getById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void getById_shouldThrowException_whenNotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());

        Exception ex = assertThrows(RuntimeException.class,
                () -> userService.getById(1));

        assertEquals("User not found", ex.getMessage());
    }

    @Test
    void register_shouldSaveUser() {
        User user = new User();
        user.setEmail("test@email.com");

        when(repo.save(user)).thenReturn(user);

//        User saved = userService.register(user);

//        assertEquals("test@email.com", saved.getEmail());
        verify(repo).save(user);
    }

    @Test
    void getByEmail_shouldReturnOptional() {
        User user = new User();
        user.setEmail("test@email.com");

        when(repo.findByEmail("test@email.com"))
                .thenReturn(Optional.of(user));

        Optional<User> result = userService.getByEmail("test@email.com");

        assertTrue(result.isPresent());
    }
}