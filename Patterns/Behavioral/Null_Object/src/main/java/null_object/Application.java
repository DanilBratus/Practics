package null_object;

public class Application {
    public static void main(String[] args) {
        AbstractEntity realEntity = new RealEntity();
        realEntity.doSomething(); // RealEntity::doSomething

        AbstractEntity unknownEntity = new NullEntity();
        unknownEntity.doSomething(); // no output
    }
}

