package com.happenings.repository;

import com.happenings.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByVenueNameAndAddressAndCityAndState(
            String venueName,
            String address,
            String city,
            String state
    );
}
