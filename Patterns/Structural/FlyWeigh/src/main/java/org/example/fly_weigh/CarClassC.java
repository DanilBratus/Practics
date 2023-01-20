package org.example.fly_weigh;

public class CarClassC extends  Car {
    public CarClassC() {
        name = "Lada";
        color = "Grey";
    }

    @Override
    public void print() {
        System.out.println("Name: " + name + ", цвет: " + color);
    }
}
