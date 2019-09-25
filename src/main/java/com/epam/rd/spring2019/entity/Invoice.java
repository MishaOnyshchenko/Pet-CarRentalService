package com.epam.rd.spring2019.entity;

import java.io.Serializable;
import java.util.Objects;

public class Invoice implements Serializable {

    private static final long serialVersionUID = -5181804200015908427L;

    private Long id;
    private String date;
    private Long orderId;
    private String description;
    private Double amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(getId(), invoice.getId()) &&
                Objects.equals(getDate(), invoice.getDate()) &&
                Objects.equals(getAmount(), invoice.getAmount()) &&
                Objects.equals(getOrderId(), invoice.getOrderId()) &&
                Objects.equals(getDescription(), invoice.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getAmount(), getOrderId(), getDescription());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", orderId=" + orderId +
                ", description='" + description + '\'' +
                '}';
    }
}