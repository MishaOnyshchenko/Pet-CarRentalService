package com.epam.rd.spring2019.web.servlet;

import com.epam.rd.spring2019.service.CarService;
import com.epam.rd.spring2019.service.CarServiceImpl;
import com.epam.rd.spring2019.web.dto.CarCreateDto;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCarServlet", urlPatterns = "/add")
public class AddCarServlet extends HttpServlet {

    private CarService carService = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarCreateDto carCreateDto = extractCarFromRequest(req);
        carService.registerCar(carCreateDto);
        resp.sendRedirect("/show");
    }

    private CarCreateDto extractCarFromRequest(HttpServletRequest req) {
        String brand = req.getParameter("brand");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String priceParam = req.getParameter("price");
        Double price = null;
        if (StringUtils.isNotEmpty(priceParam)) {
            price = Double.valueOf(priceParam);
        }
        return new CarCreateDto(brand, name, category, price);
    }
}

