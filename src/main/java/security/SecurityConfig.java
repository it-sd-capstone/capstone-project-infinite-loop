package com.happenings.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

  @Bean
  public FilterRegistrationBean<JwtFilter> jwtFilter(JwtFilter filter) {
    FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(filter);

    registration.addUrlPatterns("/api/users/*"); // protect user routes
    registration.addUrlPatterns("/api/events/*"); // protect events
    registration.addUrlPatterns("/api/secure/*"); // any secure endpoints

    return registration;
  }
}
