package org.example.filter;

import org.example.filter.model.Car;

import java.util.List;

public interface Filter {
    List<Car> filter(List<Car> cars);
}
