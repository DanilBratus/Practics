package interpreter;

public class Application {
    public static void main(String[] args) {
        LowerCase lc = new LowerCase("GHijkMMM");
        System.out.println(lc.expression(new Interpreter()));
    }
}
