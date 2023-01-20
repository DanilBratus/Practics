package org.example.factory;

import org.example.factory.service.Car;

public class Application {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car car1 = factory.create("Toyota");
        Car car2 = factory.create("Audi");
        car1.drive();
        car2.drive();
    }
}
