package com.happenings.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void gettersAndSetters_shouldWork() {
        Event event = new Event();

        LocalDateTime time = LocalDateTime.of(2026, 5, 10, 18, 0);

        event.setEventId(1);
        event.setTitle("Concert");
        event.setDescription("Live show");
        event.setEventDatetime(time);
        event.setLocationId(2);
        event.setCategoryId(3);
        event.setCreatedByUserId(10);

        assertEquals(1, event.getEventId());
        assertEquals("Concert", event.getTitle());
        assertEquals("Live show", event.getDescription());
        assertEquals(time, event.getEventDatetime());
        assertEquals(2, event.getLocationId());
        assertEquals(3, event.getCategoryId());
        assertEquals(10, event.getCreatedByUserId());
    }

    @Test
    void object_shouldAllowNullFields() {
        Event event = new Event();

        // This ensures your entity doesn't break when partially built
        assertNull(event.getTitle());
        assertNull(event.getDescription());
        assertNull(event.getEventDatetime());
        assertNull(event.getLocationId());
        assertNull(event.getCategoryId());
        assertNull(event.getCreatedByUserId());
    }

    @Test
    void eventDatetime_shouldStoreCorrectValue() {
        Event event = new Event();

        LocalDateTime now = LocalDateTime.now();
        event.setEventDatetime(now);

        assertEquals(now, event.getEventDatetime());
    }
}
