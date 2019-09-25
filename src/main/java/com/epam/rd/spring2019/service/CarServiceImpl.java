package com.epam.rd.spring2019.service;


import com.epam.rd.spring2019.converter.CarConverter;
import com.epam.rd.spring2019.dao.CarDao;
import com.epam.rd.spring2019.dao.CarDaoImpl;
import com.epam.rd.spring2019.entity.Car;
import com.epam.rd.spring2019.validator.CarValidator;
import com.epam.rd.spring2019.validator.CarValidatorImpl;
import com.epam.rd.spring2019.web.dto.CarCreateDto;
import com.epam.rd.spring2019.web.dto.CarViewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CarServiceImpl implements CarService {
    private static Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    private CarDao carDao = new CarDaoImpl();
    private CarValidator carValidator = new CarValidatorImpl();
    private CarConverter carConverter = new CarConverter();


    @Override
    public CarViewDto registerCar(CarCreateDto carCreateDto) {
        carValidator.validateNewCar(carCreateDto);
        Car car = carConverter.toCar(carCreateDto);
        car = carDao.create(car);
        return carConverter.toCarDto(car);
    }

    @Override
    public List<Car> getCars(String chosenBrand) {
        if (chosenBrand != null) {
            return getCarsByBrand(chosenBrand);
        }
        return getAllCars();
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public CarViewDto getCarById(Long id) {
        Car car = carDao.getById(id);
        return carConverter.toCarDto(car);
    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        return carDao.getByBrand(brand);
    }
}