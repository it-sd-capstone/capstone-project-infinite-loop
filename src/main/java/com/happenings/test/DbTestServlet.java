package com.happenings.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.happenings.db.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/db-test")
public class DbTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = DatabaseConnection.getConnection();

            out.println("Database connection successful!");

            conn.close();

        } catch (Exception e) {
            out.println("Database connection failed:");
            e.printStackTrace(out);
        }
    }
}