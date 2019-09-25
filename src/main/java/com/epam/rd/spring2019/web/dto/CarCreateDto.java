package com.epam.rd.spring2019.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class CarCreateDto implements Serializable {

    private static final long serialVersionUID = -2796949934596192427L;

    private String brand;
    private String name;
    private String category;
    private Double price;

    public CarCreateDto(String brand, String name, String category, Double price) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarCreateDto)) return false;
        CarCreateDto that = (CarCreateDto) o;
        return Objects.equals(getBrand(), that.getBrand()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCategory(), that.getCategory()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getName(), getCategory(), getPrice());
    }
}
