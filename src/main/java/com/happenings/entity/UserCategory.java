package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_category")
@Data
public class UserCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_category_id")
  private Integer userCategoryId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
}