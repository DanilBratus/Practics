package org.example.fly_weigh;

public class Application {
    public static void main (String [] args) {
        FlyWeigh fw = new FlyWeigh();
        String[] classCarArray = {"A", "B", "C"};
        for (String s : classCarArray) {
            fw.getCar(s).print();
        }
    }
}
