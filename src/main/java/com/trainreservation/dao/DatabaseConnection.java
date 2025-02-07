package com.trainreservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String USER = "SYSTEM";  
    private static final String PASSWORD = "BCA5C";  

    public static Connection getConnection() throws SQLException {
        try {
            // Load the Oracle JDBC driver (you might not need this if you're using a recent version of Java)
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error establishing database connection", e);
        }
    }
}
