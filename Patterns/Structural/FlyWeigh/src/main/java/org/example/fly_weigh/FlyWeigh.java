package org.example.fly_weigh;

import java.util.HashMap;
import java.util.Map;

public class FlyWeigh {
    private final Map<String, Car> cars = new HashMap<>();

    public Car getCar(String classCar){
        Car car = cars.get(classCar);
        if (car == null){
            switch (classCar){
                case "A" : {
                    car = new CarClassA();
                    break;
                }
                case "B" : {
                    car = new CarClassB();
                    break;
                }
                case "C" : {
                    car = new CarClassC();
                    break;
                }
            }
            cars.put(classCar, car);
        }
        return car;
    }
}
