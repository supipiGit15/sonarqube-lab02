package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password"; // change if needed

    public void deleteUser(String username) throws SQLException {

        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(
                    DB_URL,
                    DB_USER,
                    DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
