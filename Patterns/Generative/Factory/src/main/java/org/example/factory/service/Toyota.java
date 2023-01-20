package org.example.factory.service;

public class Toyota implements Car {

    @Override
    public void drive() {
        System.out.println("Заказ Тайоты оформлен");
    }
}
