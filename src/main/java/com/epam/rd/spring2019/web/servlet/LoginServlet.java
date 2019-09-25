package com.epam.rd.spring2019.web.servlet;


import com.epam.rd.spring2019.service.UserService;
import com.epam.rd.spring2019.service.UserServiceImpl;
import com.epam.rd.spring2019.web.dto.UserViewDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserViewDto userViewDto = userService.login(email, password);
        HttpSession session = req.getSession(true);
        session.setAttribute("user", userViewDto);
        resp.sendRedirect("/show");
    }
}