package command;

class StopCommand implements Command {
    Car car;
    public StopCommand(Car car) {
        this.car = car;
    }
    @Override
    public void execute() {
        car.stopEngine();
    }
}
