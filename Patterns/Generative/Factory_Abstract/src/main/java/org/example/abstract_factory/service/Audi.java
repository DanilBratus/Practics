package org.example.abstract_factory.service;

public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Заказ Ауди оформлен");
    }
}
