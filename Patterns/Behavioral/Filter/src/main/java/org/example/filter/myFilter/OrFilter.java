package org.example.filter.myFilter;

import org.example.filter.Filter;
import org.example.filter.model.Car;

import java.util.List;

public class OrFilter implements Filter {
    Filter oneFilter;
    Filter twoFilter;

    public OrFilter(Filter oneFilter, Filter twoFilter) {
        this.oneFilter = oneFilter;
        this.twoFilter = twoFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> list = oneFilter.filter(cars);
        List<Car> list2 = twoFilter.filter(cars);

        for (Car car : list) {
            if (!list2.contains(car)) {
                list2.add(car);
            }
        }
        return list2;
    }
}
