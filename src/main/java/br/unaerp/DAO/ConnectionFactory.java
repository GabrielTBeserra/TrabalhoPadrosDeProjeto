package br.unaerp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                new ConnectionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
