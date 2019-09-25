package com.epam.rd.spring2019.web.servlet;

import com.epam.rd.spring2019.service.UserService;
import com.epam.rd.spring2019.service.UserServiceImpl;
import com.epam.rd.spring2019.web.dto.UserCreateDto;
import com.epam.rd.spring2019.web.dto.UserViewDto;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "registrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCreateDto userCreateDto = extractUserFromRequest(req);
        UserViewDto user = userService.registerUser(userCreateDto);
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);
        resp.sendRedirect("/");
    }

    private UserCreateDto extractUserFromRequest(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String ageParam = req.getParameter("age");
        Integer age = null;
        if (StringUtils.isNotEmpty(ageParam)) {
            age = Integer.valueOf(ageParam);
        }
        return new UserCreateDto(name, surname, age, email, password);
    }
}