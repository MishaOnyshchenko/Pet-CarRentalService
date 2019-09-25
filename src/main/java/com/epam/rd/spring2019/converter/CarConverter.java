package com.epam.rd.spring2019.converter;

import com.epam.rd.spring2019.entity.Car;
import com.epam.rd.spring2019.web.dto.CarCreateDto;
import com.epam.rd.spring2019.web.dto.CarViewDto;

public class CarConverter {

    public CarViewDto toCarDto(Car car) {
        CarViewDto dto = new CarViewDto();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setName(car.getName());
        dto.setCategory(car.getCategory());
        dto.setPrice(car.getPrice());
        return dto;
    }

    public Car toCar(CarCreateDto createDto) {
        Car car = new Car();
        car.setBrand(createDto.getBrand());
        car.setName(createDto.getName());
        car.setCategory(createDto.getCategory());
        double price =(double) Math.round(createDto.getPrice() * 100d) / 100d;
        car.setPrice(price);
        return car;
    }
}