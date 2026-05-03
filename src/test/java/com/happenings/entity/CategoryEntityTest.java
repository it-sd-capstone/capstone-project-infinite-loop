package com.happenings.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void gettersAndSetters_shouldWork() {
        Category category = new Category();

        category.setCategoryId(1);
        category.setCategoryName("Music");

        assertEquals(1, category.getCategoryId());
        assertEquals("Music", category.getCategoryName());
    }

    @Test
    void object_shouldAllowNullValues() {
        Category category = new Category();

        assertNull(category.getCategoryId());
        assertNull(category.getCategoryName());
    }
}
