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

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  private Integer categoryId;
  private Integer createdByUserId;
}