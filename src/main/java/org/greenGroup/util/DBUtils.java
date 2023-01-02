package org.greenGroup.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private DBUtils() {}

    public void dropUsersTable() {
        try (Connection connection = ConnectionCreator.createConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DROP TABLE USERS";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void clearUsersTable() {
        try (Connection connection = ConnectionCreator.createConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM USERS";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void createUsersTable() {
        try (Connection connection = ConnectionCreator.createConnection();
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE USERS ("
                    + "     ID INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,"
                    + "     FIRST_NAME VARCHAR(24) NOT NULL, "
                    + "     LAST_NAME VARCHAR(24) NOT NULL, "
                    + "     AGE INTEGER NOT NULL "
                    + ");";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
