package org.example.factory;

import org.example.factory.service.Car;
import org.example.factory.service.Audi;
import org.example.factory.service.Toyota;

public class Factory {
     public Car create(String typeCar) {
         switch (typeCar) {
             case "Toyota": return new Toyota();
             case "Audi": return new Audi();
             default: return null;
         }
    }
}
