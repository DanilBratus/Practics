package state;

public class Application {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new DLS());
        context.download("File.txt");
        context.nextOS();
        context.download("F");
    }
}
