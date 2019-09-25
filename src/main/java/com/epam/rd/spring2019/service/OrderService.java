package com.epam.rd.spring2019.service;

import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.web.dto.CarViewDto;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

public interface OrderService {

    Order addOrder(OrderCreateDto order, CarViewDto car);
}
