package com.happenings.services;

import com.happenings.entity.Location;
import com.happenings.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationRepository repo;

    @InjectMocks
    private LocationService service;

    @Test
    void getAll_shouldReturnList() {
        Location location = new Location();
        location.setCity("Milwaukee");

        when(repo.findAll()).thenReturn(List.of(location));

        List<Location> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals("Milwaukee", result.get(0).getCity());
    }

    @Test
    void getAll_shouldReturnEmptyList_whenNoData() {
        when(repo.findAll()).thenReturn(List.of());

        List<Location> result = service.getAll();

        assertTrue(result.isEmpty());
    }
}