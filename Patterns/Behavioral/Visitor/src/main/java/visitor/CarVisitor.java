package visitor;

class CarVisitor implements Visitor {
    private void print(String string) {
        System.out.println(string);
    }

    @Override
    public void visit(Car car) {
        String[] carClass = car.toString().split("[\\.@]+");
        switch (carClass[1]) {
            case "SportCar":
                print("car");
                break;
            case "Engine":
                print("engine");
                break;
            case "Whell":
                print("whell");
                break;
            default:
                print("Объект не является наследником SportCar, Engine, Whell");
                break;
        }
    }
}
