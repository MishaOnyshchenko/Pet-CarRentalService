package com.epam.rd.spring2019.dao;

import com.epam.rd.spring2019.connection.JdbcConnection;
import com.epam.rd.spring2019.entity.Invoice;
import com.epam.rd.spring2019.exception.ApplicationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InvoiceDaoImpl implements InvoiceDao {

    private static final String INSERT_INVOICE_QUERY = "insert into invoices (invoice_date, order_id, invoice_description, invoice_amount) values (?, ?, ?, ?)";
    @Override
    public Invoice create(Invoice invoice) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INVOICE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, invoice.getDate());
            statement.setLong(2, invoice.getOrderId());
            statement.setString(3, invoice.getDescription());
            statement.setDouble(4, invoice.getAmount());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                invoice.setId(resultSet.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert invoice into DB", e);
        }
        return invoice;
    }
}
