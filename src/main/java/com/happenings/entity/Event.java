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

  @ManyToOne
  @JoinColumn(name = "location_id", insertable = false, updatable = false)
  private Location location;

  @ManyToOne
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private Category category;
}
