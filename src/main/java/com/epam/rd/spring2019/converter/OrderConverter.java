package com.epam.rd.spring2019.converter;

import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.web.dto.CarViewDto;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

public class OrderConverter {

    public Order toOrder(OrderCreateDto createDto, CarViewDto car) {
        Order order = new Order();
        order.setDriverLicense(createDto.getDriverLicense());
        order.setTerm(createDto.getTerm());
        order.setCarId(createDto.getCarId());
        order.setWithDriver(createDto.getWithDriver());
        order.setAmount(calculateAmount(createDto, car));

        return order;
    }

    private Double calculateAmount(OrderCreateDto createDto, CarViewDto car) {
        double amount = createDto.getTerm() * car.getPrice();
        return (double) Math.round(amount * 100d) / 100d;
    }
}
