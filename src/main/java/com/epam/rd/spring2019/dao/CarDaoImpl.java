package com.epam.rd.spring2019.dao;

import com.epam.rd.spring2019.connection.JdbcConnection;
import com.epam.rd.spring2019.entity.Car;
import com.epam.rd.spring2019.exception.ApplicationException;
import com.epam.rd.spring2019.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private static final Logger log = LoggerFactory.getLogger(CarDaoImpl.class);

    private static final String INSERT_CAR_QUERY = "INSERT INTO cars (car_brand, car_name, car_category, car_price) VALUES (?, ?, ?, ?)";
    @Override
    public Car create(Car car) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setString(3, car.getCategory());
            preparedStatement.setDouble(4, car.getPrice());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert car into DB", e);
        }
        log.info(String.format("Car added %s", car));
        return car;
    }

    private static final String ALL_CARS_QUERY = "SELECT car_id, car_brand, car_name, car_category, car_price FROM cars";
    @Override
    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();
        Car car = null;
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_CARS_QUERY);
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getLong("car_id"));
                car.setBrand(resultSet.getString("car_brand"));
                car.setName(resultSet.getString("car_name"));
                car.setCategory(resultSet.getString("car_category"));
                car.setPrice(resultSet.getDouble("car_price"));
                carList.add(car);
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load all cars from db: " + e.getMessage());
        }
        if (car == null) {
            throw new NoSuchEntityException("Car not found in db");
        }
        return carList;
    }

    private static final String CARS_BY_BRAND_QUERY = "SELECT car_id, car_brand, car_name, car_category, car_price FROM cars WHERE car_brand = '%s'";
    @Override
    public List<Car> getByBrand(String brand) {
        List<Car> carList = new ArrayList<>();
        Car car = null;
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(CARS_BY_BRAND_QUERY, brand));
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getLong("car_id"));
                car.setBrand(resultSet.getString("car_brand"));
                car.setName(resultSet.getString("car_name"));
                car.setCategory(resultSet.getString("car_category"));
                car.setPrice(resultSet.getDouble("car_price"));
                carList.add(car);
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load cars selected by brand from db: " + e.getMessage());
        }
        if (car == null) {
            throw new NoSuchEntityException("Brand not found in db");
        }
        return carList;
    }

    private static final String CAR_BY_ID_QUERY = "SELECT car_id, car_brand, car_name, car_category, car_price FROM cars WHERE car_id = '%d'";
    @Override
    public Car getById(Long carId) {
        Car car = null;
        try (Connection connection = JdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format(CAR_BY_ID_QUERY, carId));
            if (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getLong("car_id"));
                car.setBrand(resultSet.getString("car_brand"));
                car.setName(resultSet.getString("car_name"));
                car.setCategory(resultSet.getString("car_category"));
                car.setPrice(resultSet.getDouble("car_price"));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load car from DB", e);
        }
        if (car == null) {
            throw new NoSuchEntityException("Car not found by id: " + carId);
        }
        return car;
    }

    private static final String SET_CAR_QUERY = "UPDATE cars SET car_brand = ?, car_name = ?, car_category = ?, car_price = ? WHERE car_id = ?";
    @Override
    public Car set(Car car) {
        Car oldValue = getById(car.getId());
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SET_CAR_QUERY)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setString(3, car.getCategory());
            preparedStatement.setDouble(4, car.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Failed to set car into DB", e);
        }
        return oldValue;
    }

    private static final String DELETE_CAR_QUERY = "DELETE FROM cars WHERE car_id = ?";
    @Override
    public boolean remove(Long id) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            return true;
        } catch (Exception e) {
            throw new ApplicationException("Failed to remove car from DB", e);
        }
    }
}