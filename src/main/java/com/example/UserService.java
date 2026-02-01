
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
    
    public void deleteUser(String username) throws SQLException {

    String sql = "DELETE FROM users WHERE name = ?";

    String password = System.getenv("DB_PASSWORD");
    if (password == null || password.isEmpty()) {
        throw new SQLException("Database password not configured");
    }
    try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db",
                "root",
                password);
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.executeUpdate();
    }
}
}
