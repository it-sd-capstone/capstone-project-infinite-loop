package com.happenings.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/db-test")
public class DbTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            // Railway variables
            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String db   = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            // DEBUG OUTPUT
            out.println("HOST=" + host);
            out.println("PORT=" + port);
            out.println("DB=" + db);
            out.println("USER=" + user);
            out.println("PASS=" + pass);

            // Build JDBC URL
            //String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://shuttle.proxy.rlwy.net:41554/railway",
                    "root",
                    "FcbZBsceyzkySTsgCroWlaApNjhdmnpl"
            );

            //Connection conn = DriverManager.getConnection(url, user, pass);

            out.println("Database connection successful!");
            conn.close();

        } catch (Exception e) {
            out.println("Database connection failed:");
            e.printStackTrace(out);
        }
    }
}