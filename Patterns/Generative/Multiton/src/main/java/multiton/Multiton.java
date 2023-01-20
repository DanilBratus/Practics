package multiton;

import java.util.HashMap;
import java.util.Map;

public class Multiton {
    private static final Map<MultitonType, Multiton> instances = new HashMap<>();
    private final MultitonType type;

    private Multiton(MultitonType type) {
        this.type = type;
    }

    public static Multiton getInstance(MultitonType type) {
        if (!instances.containsKey(type)) {
            instances.put(type, new Multiton(type));
        }
        return instances.get(type);
    }

    @Override
    public String toString() {
        return "My number is " + type.toString();
    }
}
