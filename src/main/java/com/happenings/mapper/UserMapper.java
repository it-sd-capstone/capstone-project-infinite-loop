package com.happenings.mapper;

import com.happenings.dto.UserResponse;
import com.happenings.entity.User;

public class UserMapper {

  public static UserResponse toResponse(User user) {
    UserResponse dto = new UserResponse();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setName(user.getName());
    dto.setRole(user.getRole());
    dto.setCreatedAt(user.getCreatedAt().toString());
    return dto;
  }
}
