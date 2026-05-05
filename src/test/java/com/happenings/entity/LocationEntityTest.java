package com.happenings.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void gettersAndSetters_shouldWork() {
        Location location = new Location();

        location.setLocationId(1);
        location.setVenueName("Summer Fest Grounds");
        location.setCity("Milwaukee");
        location.setState("WI");
        location.setAddress("123 Main St");

        assertEquals(1, location.getLocationId());
        assertEquals("Summer Fest Grounds", location.getVenueName());
        assertEquals("Milwaukee", location.getCity());
        assertEquals("WI", location.getState());
        assertEquals("123 Main St", location.getAddress());
    }

    @Test
    void object_shouldAllowNullValues() {
        Location location = new Location();

        assertNull(location.getLocationId());
        assertNull(location.getVenueName());
        assertNull(location.getCity());
        assertNull(location.getState());
        assertNull(location.getAddress());
    }
}