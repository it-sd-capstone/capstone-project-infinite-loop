package com.happenings.services;

import com.happenings.entity.Category;
import com.happenings.repository.CategoryRepository;
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
class CategoryServiceTest {

    @Mock
    private CategoryRepository repo;

    @InjectMocks
    private CategoryService service;

    @Test
    void getAll_shouldReturnList() {
        when(repo.findAll()).thenReturn(List.of(new Category()));

        List<Category> result = service.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void getById_shouldReturnCategory() {
        Category category = new Category();
        category.setCategoryId(1);

        when(repo.findById(1)).thenReturn(Optional.of(category));

        Category result = service.getById(1);

        assertNotNull(result);
        assertEquals(1, result.getCategoryId());
    }

    @Test
    void create_shouldSaveCategory() {
        Category category = new Category();
        category.setCategoryName("Music");

        when(repo.save(category)).thenReturn(category);

        Category result = service.create(category);

        assertEquals("Music", result.getCategoryName());
        verify(repo).save(category);
    }

    @Test
    void update_shouldModifyCategory() {
        Category existing = new Category();
        existing.setCategoryId(1);
        existing.setCategoryName("Old");

        Category updated = new Category();
        updated.setCategoryName("New");

        when(repo.findById(1)).thenReturn(Optional.of(existing));
        when(repo.save(any())).thenReturn(existing);

        Category result = service.update(1, updated);

        assertEquals("New", result.getCategoryName());
    }

    @Test
    void delete_shouldReturnTrue_whenExists() {
        when(repo.existsById(1)).thenReturn(true);

        boolean result = service.delete(1);

        assertTrue(result);
        verify(repo).deleteById(1);
    }

    @Test
    void delete_shouldReturnFalse_whenNotExists() {
        when(repo.existsById(1)).thenReturn(false);

        boolean result = service.delete(1);

        assertFalse(result);
    }
}