package com.epam.rd.spring2019.service;

import com.epam.rd.spring2019.entity.Invoice;
import com.epam.rd.spring2019.entity.Order;

public interface InvoiceService {
    Invoice createInvoice(Order order);
}
