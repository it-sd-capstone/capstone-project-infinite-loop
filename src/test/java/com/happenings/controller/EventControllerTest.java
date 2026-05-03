package com.happenings.controller;

import com.happenings.entity.Event;
import com.happenings.security.JwtUtil;
import com.happenings.services.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventController.class)
@AutoConfigureMockMvc(addFilters = false)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;
    @MockBean
    private JwtUtil jwtUtil;


    @Test
    void getAllEvents_shouldReturn200() throws Exception {
        when(eventService.getAllEvents()).thenReturn(List.of(new Event()));

        mockMvc.perform(get("/api/events"))
                .andExpect(status().isOk());
    }

    @Test
    void getEventById_shouldReturn200() throws Exception {
        Event event = new Event();
        event.setEventId(1);

        when(eventService.getEventById(1)).thenReturn(event);

        mockMvc.perform(get("/api/events/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createEvent_shouldReturn200() throws Exception {
        Event event = new Event();
        event.setTitle("Test");

        when(eventService.createEvent(org.mockito.ArgumentMatchers.any()))
                .thenReturn(event);

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "title": "Test",
                          "description": "desc"
                        }
                        """))
                .andExpect(status().isOk());
    }
}
