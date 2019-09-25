package com.epam.rd.spring2019.entity;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {

    private static final long serialVersionUID = 937332364463147055L;

    private Long id;
    private String driverLicense;
    private Integer term;
    private Long carId;
    private Boolean withDriver;
    private Double amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Boolean getWithDriver() {
        return withDriver;
    }

    public void setWithDriver(Boolean withDriver) {
        this.withDriver = withDriver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getDriverLicense(), order.getDriverLicense()) &&
                Objects.equals(getTerm(), order.getTerm()) &&
                Objects.equals(getCarId(), order.getCarId()) &&
                Objects.equals(getWithDriver(), order.getWithDriver()) &&
                Objects.equals(getAmount(), order.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDriverLicense(), getTerm(), getCarId(), getWithDriver(), getAmount());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", driverLicense='" + driverLicense + '\'' +
                ", term=" + term +
                ", carId=" + carId +
                ", withDriver=" + withDriver +
                ", amount=" + amount +
                '}';
    }
}