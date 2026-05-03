package com.happenings.controller;

import com.happenings.entity.Category;
import com.happenings.security.JwtUtil;
import com.happenings.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService service;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    void getAll_shouldReturn200() throws Exception {
        when(service.getAll()).thenReturn(List.of(new Category()));

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk());
    }

    @Test
    void getById_shouldReturn200() throws Exception {
        Category category = new Category();
        category.setCategoryId(1);

        when(service.getById(1)).thenReturn(category);

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create_shouldReturn200() throws Exception {
        Category category = new Category();
        category.setCategoryName("Music");

        when(service.create(org.mockito.ArgumentMatchers.any()))
                .thenReturn(category);

        mockMvc.perform(post("/api/categories")
                        .contentType("application/json")
                        .content("""
                        {
                          "categoryName": "Music"
                        }
                        """))
                .andExpect(status().isOk());
    }
}