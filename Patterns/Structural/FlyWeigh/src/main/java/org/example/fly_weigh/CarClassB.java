package org.example.fly_weigh;

public class CarClassB extends Car {
    public CarClassB() {
        name = "Opel";
        color = "Red";
    }

    @Override
    public void print() {
        System.out.println("Name: " + name + ", цвет: " + color);
    }
}
