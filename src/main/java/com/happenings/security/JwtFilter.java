package com.happenings.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

  private final JwtUtil jwtUtil;

  public JwtFilter(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
          throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String path = req.getRequestURI();

    // =========================
    // ALLOW NON-API ROUTES
    // (frontend pages, static pages)
    // =========================
    if (!path.startsWith("/api/")) {
      chain.doFilter(request, response);
      return;
    }

    // =========================
    // CHECK AUTH HEADER
    // =========================
    String authHeader = req.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing token");
      return;
    }

    String token = authHeader.substring(7);

    // =========================
    // VALIDATE TOKEN
    // =========================
    if (!jwtUtil.validateToken(token)) {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
      return;
    }

    chain.doFilter(request, response);
  }
}