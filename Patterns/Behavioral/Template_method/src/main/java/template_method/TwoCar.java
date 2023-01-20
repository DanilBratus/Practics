package template_method;

class TwoCar extends Car {
    public void startEngine() {
        System.out.println("Two Car. Start engine.");
    }
    public void stopEngine() {
        System.out.println("Two Car. Stop engine.");
    }
}
