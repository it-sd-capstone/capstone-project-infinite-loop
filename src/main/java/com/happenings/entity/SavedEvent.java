package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(SavedEventId.class)
@Table(name = "saved_event")
public class SavedEvent {

  @Id
  @Column(name = "event_id")
  private Integer eventId;

  @Id
  @Column(name = "user_id")
  private Integer userId;

  @ManyToOne
  @JoinColumn(name = "event_id", insertable = false, updatable = false)
  private Event event;

  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;
}
