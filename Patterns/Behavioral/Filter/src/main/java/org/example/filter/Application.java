package org.example.filter;

import org.example.filter.model.Car;
import org.example.filter.myFilter.DoorFilter;
import org.example.filter.myFilter.OrFilter;
import org.example.filter.myFilter.SpeedFilter;
import org.example.filter.myFilter.TwoFilter;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Audi", "green", 220, 4));
        carList.add(new Car("Mercedes Benz", "wait", 280, 2));
        carList.add(new Car("Lada", "wait", 80, 4));
        carList.add(new Car("Schiguly", "wait", 60, 2));
        System.out.println("Список машин: " + carList);

        Filter speedFilter = new SpeedFilter();
        System.out.println("Фильтрация по скорости: " + speedFilter.filter(carList));

        Filter doorFilter = new DoorFilter();
        System.out.println("Фильтрация по кол-ву дверей: " + doorFilter.filter(carList));

        Filter twoFilter = new TwoFilter(speedFilter, doorFilter);
        System.out.println("Фильтрация по двум фильтрам: " + twoFilter.filter(carList));

        Filter orFilter = new OrFilter(speedFilter,doorFilter);
        System.out.println("Фильтрация по одному из фильтров: " + orFilter.filter(carList));
    }
}