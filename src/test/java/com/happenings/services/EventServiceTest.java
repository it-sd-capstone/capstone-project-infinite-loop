package com.happenings.services;

import com.happenings.entity.Event;
import com.happenings.repository.EventRepository;
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
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    void getAllEvents_shouldReturnList() {
        when(eventRepository.findAll()).thenReturn(List.of(new Event()));

        List<Event> result = eventService.getAllEvents();

        assertEquals(1, result.size());
        verify(eventRepository).findAll();
    }

    @Test
    void getEventById_shouldReturnEvent() {
        Event event = new Event();
        event.setEventId(1);

        when(eventRepository.findById(1)).thenReturn(Optional.of(event));

        Event result = eventService.getEventById(1);

        assertNotNull(result);
        assertEquals(1, result.getEventId());
    }

    @Test
    void createEvent_shouldSaveEvent() {
        Event event = new Event();
        event.setTitle("Test Event");

        when(eventRepository.save(event)).thenReturn(event);

        Event result = eventService.createEvent(event);

        assertEquals("Test Event", result.getTitle());
        verify(eventRepository).save(event);
    }

    @Test
    void deleteEvent_shouldReturnTrueIfExists() {
        when(eventRepository.existsById(1)).thenReturn(true);

        boolean result = eventService.deleteEvent(1);

        assertTrue(result);
        verify(eventRepository).deleteById(1);
    }
}
