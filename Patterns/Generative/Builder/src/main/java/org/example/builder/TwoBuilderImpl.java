package org.example.builder;

class TwoBuilderImpl extends Builder {
    public TwoBuilderImpl() {
        car = new Car();
    }

    @Override
    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine(engine);
        car.buildWheels();
        engine = new TwoEngine();
        car.buildEngine(engine);
        return car;
    }
}
