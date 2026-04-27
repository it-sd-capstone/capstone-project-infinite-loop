package com.happenings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.happenings.db.DatabaseConnection;
import com.happenings.model.User;

public class UserDao {

    //
    // CREATE USER
    //
    public void createUser(String username, String email, String password) throws Exception {

        String sql = "INSERT INTO USER (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);

            stmt.executeUpdate();
        }
    }

    //
    // GET USER BY ID
    //
    public User getUserById(int userId) throws Exception {

        String sql = "SELECT * FROM USER WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        }

        return null;
    }

    //
    // GET USER BY EMAIL (LOGIN)
    //
    public User getUserByEmail(String email) throws Exception {

        String sql = "SELECT * FROM USER WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        }

        return null;
    }
}