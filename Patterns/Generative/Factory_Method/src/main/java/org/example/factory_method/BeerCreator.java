package org.example.factory_method;

public class BeerCreator extends Creator{
    @Override
    public Product factoryMethod() {
        return new Beer();
    }
}
