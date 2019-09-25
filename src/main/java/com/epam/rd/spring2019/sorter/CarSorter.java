package com.epam.rd.spring2019.sorter;

import com.epam.rd.spring2019.entity.Car;

import java.util.Comparator;
import java.util.List;

public class CarSorter {

    public List<Car> sort(List<Car> cars, String sortBy) {
        if (sortBy == null) {
            return cars;
        } else if (sortBy.equals("name")) {
            cars.sort(new SorterByName());
        } else if (sortBy.equals("price")) {
            cars.sort(new SorterByPrice());
        } else if (sortBy.equals("brand")) {
            cars.sort(new SorterByBrand());
        } else if (sortBy.equals("category")) {
            cars.sort(new SorterByCategory());
        }
        return cars;
    }

    class SorterByName implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return a.getName().compareToIgnoreCase(b.getName());
        }
    }

    class SorterByPrice implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return Double.compare(a.getPrice(), b.getPrice());
        }
    }

    class SorterByBrand implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return a.getBrand().compareToIgnoreCase(b.getBrand());
        }
    }

    class SorterByCategory implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return a.getCategory().compareToIgnoreCase(b.getCategory());
        }
    }
}