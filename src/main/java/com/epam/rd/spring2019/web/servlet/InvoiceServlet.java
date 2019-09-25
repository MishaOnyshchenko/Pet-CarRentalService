package com.epam.rd.spring2019.web.servlet;

import com.epam.rd.spring2019.entity.Invoice;
import com.epam.rd.spring2019.entity.Order;
import com.epam.rd.spring2019.service.InvoiceService;
import com.epam.rd.spring2019.service.InvoiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "invoiceServlet", urlPatterns = "/invoice")

public class InvoiceServlet extends HttpServlet {

    private InvoiceService invoiceService = new InvoiceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = (Order) req.getAttribute("order");
        Invoice invoice = invoiceService.createInvoice(order);
        req.setAttribute("invoice", invoice);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/invoice.jsp");
        requestDispatcher.forward(req, resp);
    }
}