package org.greenGroup.dao;



import org.greenGroup.util.DBUtils;
import org.greenGroup.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private final DBUtils database;
    private final int transactionIsolation = Connection.TRANSACTION_REPEATABLE_READ;

    public UserDao(DBUtils database) {
        this.database = database;
    }

    private User extractUserFromResulSe(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id") );
        user.setFirstName(rs.getString("first_name") );
        user.setLastName(rs.getString("last_name"));
        user.setAge(rs.getInt("age"));
        return user;
    }

    public Optional<User> getUserById(long id) {
        String SQL = "SELECT * FROM users WHERE id=";

        try (Connection connection = database.getConnection()){
            connection.setTransactionIsolation(transactionIsolation);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL + id);

            if(rs.next()) {
                return Optional.of(extractUserFromResulSe(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "SELECT * FROM users";


        try(Connection connection = database.getConnection();
            Statement stmt = connection.createStatement()) {
            connection.setTransactionIsolation(transactionIsolation);

            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                users.add(extractUserFromResulSe(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User saveUser(User user) {
        String SQL = "INSERT INTO USERS (first_name, last_name, age) VALUES (?,?,?)";

        try(Connection connection = database.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setInt(3,user.getAge());
            ps.executeUpdate();
            connection.commit();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs != null && rs.next()) {
                long id = ps.getGeneratedKeys().getLong(1);
                user.setId(id);
                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        throw new RuntimeException();
    }

    public int deleteUserByLastName(String lastName) {
        String SQL = "DELETE FROM users WHERE last_name = ?";

        int affectedRows = 0;

        try (Connection connection = database.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);
            pstmt.setString(1,lastName);

            affectedRows = pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    public int deleteUserById(long id) {
        String SQL = "DELETE FROM users WHERE id = ?";

        int affectedRows = 0;

        try (Connection connection = database.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);

            pstmt.setLong(1,id);

            affectedRows = pstmt.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    public int updateUserById(User user, long id) {
        String SQL = "UPDATE users SET first_name = ?, last_name = ?, age = ? WHERE id = ?";

        int affectedRows = 0;

        try (Connection connection = database.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setInt(3, user.getAge());
            pstmt.setLong(4, id);

            affectedRows = pstmt.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }
}
