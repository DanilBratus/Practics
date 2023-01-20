package org.example.abstract_factory.service;

public class Honda implements Moto {
    @Override
    public void drive() {
        System.out.println("Заказ на Honda принят");
    }
}
