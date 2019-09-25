package com.epam.rd.spring2019.entity;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private static final long serialVersionUID = -6052124747284828240L;

    private Long id;
    private String brand;
    private String name;
    private String category;
    private Double price;

    public Car() {
    }

    public Car(Long id, String brand, String name, String category, Double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) &&
                Objects.equals(getBrand(), car.getBrand()) &&
                Objects.equals(getName(), car.getName()) &&
                Objects.equals(getCategory(), car.getCategory()) &&
                Objects.equals(getPrice(), car.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getName(), getCategory(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

