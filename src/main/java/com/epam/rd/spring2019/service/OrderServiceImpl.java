package com.epam.rd.spring2019.service;

import com.epam.rd.spring2019.converter.OrderConverter;
import com.epam.rd.spring2019.dao.OrderDao;
import com.epam.rd.spring2019.dao.OrderDaoImpl;
import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.web.dto.CarViewDto;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderConverter orderConverter = new OrderConverter();

    @Override
    public Order addOrder(OrderCreateDto dto, CarViewDto car) {
        Order order = orderConverter.toOrder(dto, car);
        return orderDao.create(order);
    }
}