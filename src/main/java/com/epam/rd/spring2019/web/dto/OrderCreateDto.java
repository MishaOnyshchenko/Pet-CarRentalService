package com.epam.rd.spring2019.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class OrderCreateDto implements Serializable {

    private static final long serialVersionUID = 3727448207655380400L;

    private String driverLicense;
    private Integer term;
    private Long carId;
    private Boolean withDriver;

    public OrderCreateDto(String driverLicense, Integer term, Long carId, Boolean withDriver) {
        this.driverLicense = driverLicense;
        this.term = term;
        this.carId = carId;
        this.withDriver = withDriver;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCreateDto)) return false;
        OrderCreateDto that = (OrderCreateDto) o;
        return Objects.equals(getDriverLicense(), that.getDriverLicense()) &&
                Objects.equals(getTerm(), that.getTerm()) &&
                Objects.equals(getCarId(), that.getCarId()) &&
                Objects.equals(getWithDriver(), that.getWithDriver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriverLicense(), getTerm(), getCarId(), getWithDriver());
    }

    @Override
    public String toString() {
        return "OrderCreateDto{" +
                "driverLicense='" + driverLicense + '\'' +
                ", term=" + term +
                ", carId=" + carId +
                ", withDriver=" + withDriver +
                '}';
    }
}
