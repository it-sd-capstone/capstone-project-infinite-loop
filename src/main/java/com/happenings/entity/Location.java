package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "location")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "location_id")
  private Integer locationId;

  @Column(name = "venue_name")
  private String venueName;

  private String city;
  private String state;
  private String address;
}
