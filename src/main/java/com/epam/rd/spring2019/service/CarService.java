package com.epam.rd.spring2019.service;

import com.epam.rd.spring2019.entity.Car;
import com.epam.rd.spring2019.web.dto.CarCreateDto;
import com.epam.rd.spring2019.web.dto.CarViewDto;

import java.util.List;

public interface CarService {

    CarViewDto registerCar(CarCreateDto carCreateDto);

    List<Car> getAllCars();

    CarViewDto getCarById(Long id);

    List<Car> getCars(String chosenBrand);

    List<Car> getCarsByBrand(String brand);

}
