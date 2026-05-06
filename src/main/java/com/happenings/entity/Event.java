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

  private Integer locationId;
  private Integer categoryId;
  private Integer createdByUserId;
}