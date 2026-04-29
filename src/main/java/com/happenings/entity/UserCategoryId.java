package com.happenings.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserCategoryId implements Serializable {
  private Integer userId;
  private Integer categoryId;
}
