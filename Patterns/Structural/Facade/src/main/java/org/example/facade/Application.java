package org.example.facade;

import org.example.facade.service.Facade;

public class Application {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stopCar();
    }
}
