package com.happenings.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Profile("prod")
public class SecurityConfigProd {

  private final JwtUtil jwtUtil;

  public SecurityConfigProd(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Bean
  public JwtFilter jwtFilter() {
    return new JwtFilter(jwtUtil);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
