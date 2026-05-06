package com.happenings.dto;

import lombok.Data;
import java.util.List;

@Data
public class RegisterRequest {
  private String name;
  private String username;
  private String email;
  private String password;
  private String confirmPassword;
  private List<Integer> categoryId;
}
