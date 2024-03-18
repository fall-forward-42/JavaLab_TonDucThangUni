package org.tdtu.lab5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void registerUser(User user) {
        String insertQuery = "INSERT INTO users(username, password, fullname) VALUES (?, ?, ?)";

        try (PreparedStatement pst = this.connection.prepareStatement(insertQuery)) {
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullName());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
