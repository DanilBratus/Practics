package org.example.facade.service;

public class Facade {
    private final Key key;
    private final Engine engine;

    public Facade() {
        key = new Key();
        engine = new Engine();
    }

    public void startCar() {
        key.start();
        engine.start();
    }

    public void stopCar() {
        key.stop();
        engine.stop();
    }
}
