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

  // GET LOCATION BY ID
  public Location getById(Integer id) {
    return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Location not found"));
  }

  // RETRIEVES LOCATION IF EXISTS OR CREATES NEW
  public Location findOrCreate(String venueName, String address, String city, String state) {

      return repo
              .findByVenueNameAndAddressAndCityAndState(
                      venueName, address, city, state
              )
              .orElseGet(() -> {
                  Location loc = new Location();
                  loc.setVenueName(venueName);
                  loc.setAddress(address);
                  loc.setCity(city);
                  loc.setState(state);
                  return repo.save(loc);
              });
  }

}
