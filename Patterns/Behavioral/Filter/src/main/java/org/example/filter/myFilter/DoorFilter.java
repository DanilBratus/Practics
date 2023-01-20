package org.example.filter.myFilter;

import org.example.filter.Filter;
import org.example.filter.model.Car;

import java.util.ArrayList;
import java.util.List;

public class DoorFilter implements Filter {
    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDoor() > 2) {
                list.add(car);
            }
        }
        return list;
    }
}
