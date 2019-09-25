package com.epam.rd.spring2019.dao;

import com.epam.rd.spring2019.connection.JdbcConnection;
import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.exception.ApplicationException;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDaoImpl implements OrderDao {


    private static final String INSERT_ORDER_QUERY = "insert into orders (driver_license, term, car, with_driver, order_amount) values (?, ?, ?, ?, ?)";
    @Override
    public Order create(Order order) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, order.getDriverLicense());
            statement.setInt(2, order.getTerm());
            statement.setLong(3, order.getCarId());
            statement.setBoolean(4, order.getWithDriver());
            statement.setDouble(5, order.getAmount());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert order into DB", e);
        }
        return order;
    }
}
