package template_method;

class OneCar extends Car {
    public void startEngine() {
        System.out.println("One Car. Start engine.");
    }
    public void stopEngine() {
        System.out.println("One Car. Stop engine.");
    }
}
