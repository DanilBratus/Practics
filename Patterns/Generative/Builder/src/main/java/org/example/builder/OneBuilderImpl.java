package org.example.builder;

class OneBuilderImpl extends Builder {
    public OneBuilderImpl() {
        car = new Car();
    }

    @Override
    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine(engine);
        return car;
    }
}
