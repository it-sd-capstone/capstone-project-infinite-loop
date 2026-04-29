package com.happenings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(UserCategoryId.class)
@Table(name = "user_category")
public class UserCategory {

  @Id
  @Column(name = "user_id")
  private Integer userId;

  @Id
  @Column(name = "category_id")
  private Integer categoryId;

  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private Category category;
}
