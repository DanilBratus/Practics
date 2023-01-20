package command;

public class Application {
    public static void main(String[] args) {
        new Invoker().execute(new StartCommand(new Car()));
        new Invoker().execute(new StopCommand(new Car()));
    }
}
