package strategy;

public class Application {
    public static void main(String[] args) {
        Context context = new Context(new DWS());
        context.download("file.txt");
        context = new Context(new DLS());
        context.download("file.txt");
    }
}
