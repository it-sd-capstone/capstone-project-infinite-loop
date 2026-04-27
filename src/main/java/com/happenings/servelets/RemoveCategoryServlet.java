package com.happenings.servelets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveCategoryServlet", value = "/RemoveCategoryServlet")
public class RemoveCategoryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    response.getWriter().println("<h1>Hello from RemoveCategoryServlet!</h1>");
  }
}
