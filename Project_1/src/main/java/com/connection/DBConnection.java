package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	
	private static Connection connection = null;

    private DBConnection(){}

    public static Connection getConnection() throws SQLException {

        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/project1";
            String username = "root";
            String password = "Calallen1103";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}
