package com.epam.rd.spring2019.dao;


import com.epam.rd.spring2019.connection.JdbcConnection;
import com.epam.rd.spring2019.entity.User;
import com.epam.rd.spring2019.exception.ApplicationException;
import com.epam.rd.spring2019.exception.NoSuchEntityException;

import java.sql.*;


public class UserDaoImpl implements UserDao {

    private static final String USER_BY_EMAIL_QUERY = "select * from users where user_email = '%s'";
    @Override
    public User getByEmail(String email) {
        User user = null;
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(USER_BY_EMAIL_QUERY, email));
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setName(resultSet.getString("user_name"));
                user.setSurname(resultSet.getString("user_surname"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPassword(resultSet.getString("user_password"));
                user.setAge(resultSet.getInt("user_age"));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load user from DB", e);
        }
        if (user == null) {
            throw new NoSuchEntityException("User not found by email: " + email);
        }
        return user;
    }

    private static final String INSERT_USER_QUERY = "insert into users (user_name, user_surname, user_age, user_email, user_password) values (?, ?, ?, ?, ?)";
    @Override
    public User create(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert user into DB", e);
        }
        return user;
    }


    public boolean checkUserIfExists(String email) {
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(USER_BY_EMAIL_QUERY, email));
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new ApplicationException("Failed to check email", e);
        }
        return false;
    }
}