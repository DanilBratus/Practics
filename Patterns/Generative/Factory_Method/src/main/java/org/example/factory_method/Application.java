package org.example.factory_method;

public class Application {
    public static void main(String[] args) {
        Creator creator = new BeerCreator();
        creator.factoryMethod();
    }
}
