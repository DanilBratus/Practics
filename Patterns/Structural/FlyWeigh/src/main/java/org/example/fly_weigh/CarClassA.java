package org.example.fly_weigh;

public class CarClassA extends Car {
    public CarClassA() {
        name = "Ford";
        color = "Green";
    }

    @Override
    public void print() {
        System.out.println("Name: " + name + ", цвет: " + color);
    }
}
