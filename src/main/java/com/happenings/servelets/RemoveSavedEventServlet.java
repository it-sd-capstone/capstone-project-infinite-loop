package com.happenings.servelets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveSavedEventServlet", value = "/RemoveSavedEventServlet")
public class RemoveSavedEventServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    response.getWriter().println("<h1>Hello from RemoveSavedEventServlet!</h1>");
  }
}
