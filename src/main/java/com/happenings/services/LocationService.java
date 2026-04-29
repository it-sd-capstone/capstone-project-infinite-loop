package com.happenings.services;

import com.happenings.entity.Location;
import com.happenings.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

  private final LocationRepository repo;

  public LocationService(LocationRepository repo) {
    this.repo = repo;
  }

  public List<Location> getAll() {
    return repo.findAll();
  }
}
