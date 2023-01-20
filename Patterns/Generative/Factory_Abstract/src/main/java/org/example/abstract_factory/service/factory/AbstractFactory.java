package org.example.abstract_factory.service.factory;

public class AbstractFactory {
    public Factory carFactory(String typeFactory) {
        switch (typeFactory) {
            case "Car": return new CarFactory();
            case "Moto": return new MotoFactory();
            default: return null;
        }
    }
}
