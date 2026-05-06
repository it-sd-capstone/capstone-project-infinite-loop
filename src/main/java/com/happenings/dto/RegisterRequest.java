package com.happenings.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterRequest {
  private String username;
  private String email;
  private String password;
  private List<String> categories;
}
