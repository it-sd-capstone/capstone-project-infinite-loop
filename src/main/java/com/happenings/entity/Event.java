package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id")
  private Integer eventId;

  private String title;

  private String description;

  @Column(name = "event_datetime")
  private LocalDateTime eventDatetime;

  @Column(name = "location_id")
  private Integer locationId;

  @Column(name = "category_id")
  private Integer categoryId;

  // Optional relationships (safe for reads only)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id", insertable = false, updatable = false)
  private Location location;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private Category category;
}