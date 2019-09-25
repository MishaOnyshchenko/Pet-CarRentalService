package com.epam.rd.spring2019.service;

import com.epam.rd.spring2019.dao.InvoiceDao;
import com.epam.rd.spring2019.dao.InvoiceDaoImpl;
import com.epam.rd.spring2019.entity.Invoice;
import com.epam.rd.spring2019.entity.Order;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceDao invoiceDao = new InvoiceDaoImpl();

    @Override
    public Invoice createInvoice(Order order) {
        return invoiceDao.create(issueInvoice(order));
    }

    private Invoice issueInvoice(Order order) {
        Invoice invoice = new Invoice();
        invoice.setDate(getDate());
        invoice.setOrderId(order.getId());
        invoice.setDescription(makeDescription(order.getCarId()));
        invoice.setAmount(order.getAmount());

        return invoice;
    }

    private String getDate() {
        Locale locale = Locale.getDefault();
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        Date today = new Date();
        return dateFormatter.format(today);
    }

    private String makeDescription(Long carId) {
        return String.format("Rent car, id # %d", carId);
    }
}