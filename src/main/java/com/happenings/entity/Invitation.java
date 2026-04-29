package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "invitation")
public class Invitation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer invitationId;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private User sender;

  @ManyToOne
  @JoinColumn(name = "receiver_id")
  private User receiver;

  private String status;
}
