package org.example.adapter.service;

public class SimpleAmericanSocket implements AmericanSocket {
    @Override
    public void getPower() {
        System.out.println("Напряжение: 110 Вольт");
    }
}
