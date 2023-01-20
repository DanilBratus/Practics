package org.example.abstract_factory.service.factory;

import org.example.abstract_factory.service.Audi;
import org.example.abstract_factory.service.Toyota;
import org.example.abstract_factory.service.Car;

public class CarFactory extends Factory {
    @Override
    public Car createCar(String typeCar) {
        switch (typeCar) {
            case "Toyota": return new Toyota();
            case "Audi": return new Audi();
            default: return null;
        }
    }
}
