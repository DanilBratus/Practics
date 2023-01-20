package visitor;

public class Application {
    public static void main(String[] args) {
        SportCar computer = new SportCar();
        computer.accept(new CarVisitor());
    }
}
