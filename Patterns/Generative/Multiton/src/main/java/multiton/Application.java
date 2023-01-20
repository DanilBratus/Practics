package multiton;

public class Application {
    public static void main(String[] args) {
        Multiton m0 = Multiton.getInstance(MultitonType.ZERO);
        Multiton m1 = Multiton.getInstance(MultitonType.ONE);
        Multiton m2 = Multiton.getInstance(MultitonType.TWO);
        System.out.println(m0);
        System.out.println(m1);
        System.out.println(m2);
    }
}
