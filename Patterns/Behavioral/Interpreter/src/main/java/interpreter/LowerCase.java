package interpreter;

public class LowerCase implements Expression{
    private final String s;

    public LowerCase(String s) {
        this.s = s;
    }

    @Override
    public String expression(Interpreter interpreter) {
        return interpreter.toLoverCase(this.s);
    }
}
