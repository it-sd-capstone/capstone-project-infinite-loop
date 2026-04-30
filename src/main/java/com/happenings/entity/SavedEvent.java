package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "saved_event")
public class SavedEvent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "saved_event_id")
  private Integer savedEventId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;
}