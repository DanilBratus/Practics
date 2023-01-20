package org.example.filter.model;

public class Car {
    private String model;
    private String color;
    private int speed;
    private int door;

    public Car(String model, String color, int speed, int door) {
        this.model = model;
        this.color = color;
        this.speed = speed;
        this.door = door;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDoor() {
        return door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", door=" + door +
                '}';
    }
}
