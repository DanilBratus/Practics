package org.example.factory.service;

public class Audi implements Car {

    @Override
    public void drive() {
        System.out.println("Заказ Ауди оформлен");
    }
}
