package com.happenings.mapper;

import com.happenings.dto.RegisterRequest;
import com.happenings.dto.UserResponse;
import com.happenings.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toEntity(RegisterRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    user.setName(request.getName());
    return user;
  }

  public UserResponse toResponse(User user) {
    UserResponse response = new UserResponse();
    response.setId(user.getId());
    response.setUsername(user.getUsername());
    response.setEmail(user.getEmail());
    response.setName(user.getName());
    response.setRole(user.getRole());
    return response;
  }
}
