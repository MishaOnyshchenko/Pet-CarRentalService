package com.epam.rd.spring2019.web.servlet;

import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.service.CarService;
import com.epam.rd.spring2019.service.CarServiceImpl;
import com.epam.rd.spring2019.service.OrderService;
import com.epam.rd.spring2019.service.OrderServiceImpl;
import com.epam.rd.spring2019.web.dto.CarViewDto;
import com.epam.rd.spring2019.web.dto.OrderCreateDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "orderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private CarService carService = new CarServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private CarViewDto car = new CarViewDto();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("carId"));
        car = carService.getCarById(id);
        req.setAttribute("car", car);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/makeOrder.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderCreateDto orderCreateDto = extractOrderFromRequest(req);
        Order order = orderService.addOrder(orderCreateDto, car);
        req.setAttribute("order", order);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/invoice");
        requestDispatcher.forward(req, resp);
    }

    private OrderCreateDto extractOrderFromRequest(HttpServletRequest req) {
        String driverLicense = req.getParameter("license");
        Integer term = Integer.valueOf(req.getParameter("term"));
        Long carId = Long.valueOf(req.getParameter("carId"));
        boolean withDriver = false;
        if (req.getParameter("withDriver") != null) {
            withDriver = true;
        }
        return new OrderCreateDto(driverLicense, term, carId, withDriver);
    }
}