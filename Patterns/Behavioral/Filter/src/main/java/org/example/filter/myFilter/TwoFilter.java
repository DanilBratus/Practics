package org.example.filter.myFilter;

import org.example.filter.Filter;
import org.example.filter.model.Car;

import java.util.List;

public class TwoFilter implements Filter {
    Filter oneFilter;
    Filter twoFilter;

    public TwoFilter(Filter oneFilter, Filter twoFilter) {
        this.oneFilter = oneFilter;
        this.twoFilter = twoFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> list = oneFilter.filter(cars);
        return twoFilter.filter(list);
    }
}
