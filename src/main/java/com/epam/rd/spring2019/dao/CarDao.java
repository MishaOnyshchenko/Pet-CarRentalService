package com.epam.rd.spring2019.dao;

import com.epam.rd.spring2019.entity.Car;

import java.util.List;

public interface CarDao {

    Car create(Car car);

    List<Car> getAll();

    Car getById(Long id);

    Car set(Car car);

    boolean remove(Long id);

    List<Car> getByBrand(String brand);
}

