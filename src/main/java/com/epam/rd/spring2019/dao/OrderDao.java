package com.epam.rd.spring2019.dao;

import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

public interface OrderDao {

    Order create(Order order);
}
