package org.example.abstract_factory;

import org.example.abstract_factory.service.factory.AbstractFactory;

public class Application {
    public static void main(String[] args) {
        new AbstractFactory().carFactory("Car").createCar("Toyota").drive();
        new AbstractFactory().carFactory("Car").createCar("Audi").drive();
        new AbstractFactory().carFactory("Moto").createMoto("Yomaha").drive();
        new AbstractFactory().carFactory("Moto").createMoto("Honda").drive();
    }
}
