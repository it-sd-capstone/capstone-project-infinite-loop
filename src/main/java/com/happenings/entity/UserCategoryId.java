package com.happenings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserCategoryId implements Serializable {

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "category_id")
  private Integer categoryId;

  public UserCategoryId() {}

  public UserCategoryId(Integer userId, Integer categoryId) {
    this.userId = userId;
    this.categoryId = categoryId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserCategoryId that = (UserCategoryId) o;
    return Objects.equals(userId, that.userId) &&
            Objects.equals(categoryId, that.categoryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, categoryId);
  }
}
