package org.greenGroup.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final String DB_URL;
    private static final Properties properties = new Properties();

    static {
        try (InputStream resourceAsStream =
                     ConnectionCreator.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(resourceAsStream);
            String driverName = properties.getProperty("db.driver");
            Class.forName(driverName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        DB_URL = properties.getProperty("db.url");
    }

    private ConnectionCreator() {}

    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(DB_URL, properties);
        } catch (SQLException e) {
            System.err.println("Connection with DB FAILED, check properties, " + e.getMessage());
            throw new RuntimeException();
        }
    }
}

