package br.com.saat.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/saat", "usuario", "usuario");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
