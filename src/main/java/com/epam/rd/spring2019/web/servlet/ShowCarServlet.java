package com.epam.rd.spring2019.web.servlet;

import com.epam.rd.spring2019.entity.Car;
import com.epam.rd.spring2019.service.CarService;
import com.epam.rd.spring2019.service.CarServiceImpl;
import com.epam.rd.spring2019.sorter.CarSorter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showCarServlet", urlPatterns = "/show")
public class ShowCarServlet extends HttpServlet {

    private CarService carService = new CarServiceImpl();
    private CarSorter carSorter = new CarSorter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getCars(req.getParameter("chosenBrand"));
        List<Car> sortedCars = carSorter.sort(cars, req.getParameter("sortBy"));
        req.setAttribute("cars", sortedCars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showCars.jsp");
        requestDispatcher.forward(req, resp);
    }
}