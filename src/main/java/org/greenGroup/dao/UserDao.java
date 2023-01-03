package org.greenGroup.dao;

import org.greenGroup.constant.SqlRequestConstant;
import org.greenGroup.util.ConnectionCreator;
import org.greenGroup.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {
    private final int transactionIsolation = Connection.TRANSACTION_REPEATABLE_READ;

    public UserDao() {
    }

    private User extractUserFromResulSe(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id") );
        user.setFirstName(rs.getString("first_name") );
        user.setLastName(rs.getString("last_name"));
        user.setAge(rs.getInt("age"));
        return user;
    }

    public Optional<User> getUserById(Long id) {

        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequestConstant.SELECT_ALL_FROM_USERS_BY_ID)) {

            connection.setTransactionIsolation(transactionIsolation);

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(extractUserFromResulSe(resultSet));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequestConstant.SELECT_ALL_FROM_USERS)) {

            connection.setTransactionIsolation(transactionIsolation);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(extractUserFromResulSe(resultSet));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void saveUser(User user) {

        try(Connection connection = ConnectionCreator.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequestConstant.INSERT_INTO_USERS_BY_VALUES,
                    Statement.RETURN_GENERATED_KEYS)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3,user.getAge());
            preparedStatement.executeUpdate();
            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet != null && resultSet.next()) {
                Long id = preparedStatement.getGeneratedKeys().getLong(1);
                user.setId(id);
            } else {
                throw new RuntimeException();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int deleteUserById(Long id) {
        int affectedRows = 0;

        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequestConstant.DELETE_FROM_USERS_BY_ID)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);

            preparedStatement.setLong(1,id);

            affectedRows = preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    public int updateUserById(User user, Long id) {
        int affectedRows = 0;

        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequestConstant.UPDATE_USERS_BY_VALUES)) {
            connection.setTransactionIsolation(transactionIsolation);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setLong(4, id);

            affectedRows = preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }
}
