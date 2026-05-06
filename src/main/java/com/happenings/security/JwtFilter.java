package com.happenings.security;

import com.happenings.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;
  private final UserService userService;

  public JwtFilter(JwtUtil jwtUtil, UserService userService) {
    this.jwtUtil = jwtUtil;
    this.userService = userService;
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    String path = request.getRequestURI();
    return path.equals("/register") || path.equals("/login");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req,
                                  HttpServletResponse res,
                                  FilterChain chain)
          throws ServletException, IOException {

    String authHeader = req.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {

      String token = authHeader.substring(7);

      if (jwtUtil.validateToken(token)) {

        String email = jwtUtil.extractUsername(token);

        var optionalUser = userService.findByEmail(email);

        if (optionalUser.isPresent()) {
          var user = optionalUser.get();

          var auth = new UsernamePasswordAuthenticationToken(
                  user, null, null
          );

          auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

          SecurityContextHolder.getContext().setAuthentication(auth);
        }
      }
    }

    chain.doFilter(req, res);
  }
}
