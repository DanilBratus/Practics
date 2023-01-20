package interpreter;

public class UpperCase implements Expression {
    private final String s;

    public UpperCase(String s) {
        this.s = s;
    }

    @Override
    public String expression(Interpreter interpreter) {
        return interpreter.toUpperCase(this.s);
    }
}
