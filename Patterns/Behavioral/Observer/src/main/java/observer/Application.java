package observer;

public class Application {
    public static void main(String[] args) {
        University university = new University();
        Director director = new Director();

        university.addObserver(director);
        university.addStudent("Anna");
        university.addStudent("Vaska");
    }
}
