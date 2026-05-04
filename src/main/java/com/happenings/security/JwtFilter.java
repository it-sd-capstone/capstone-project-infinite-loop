package com.happenings.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;

  public JwtFilter(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    String path = request.getRequestURI();
    return path.startsWith("/api/auth/");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req,
                                  HttpServletResponse res,
                                  FilterChain chain)
          throws ServletException, IOException {

    String authHeader = req.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing token");
      return;
    }

    String token = authHeader.substring(7);

    if (!jwtUtil.validateToken(token)) {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
      return;
    }

    chain.doFilter(req, res);
  }
}
