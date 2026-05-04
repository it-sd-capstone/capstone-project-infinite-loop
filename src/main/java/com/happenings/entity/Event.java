package com.happenings.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

  @Column(name = "created_by_user_id")
  private Integer createdByUserId;


  // Prevent JSON serialization crash
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id", insertable = false, updatable = false)
  private Location location;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private Category category;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by_user_id", insertable = false, updatable = false)
  private User createdBy;
}