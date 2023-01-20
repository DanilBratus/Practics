package observer;

import java.util.List;

class Director implements Observer {
    @Override
    public void event(List<String> strings) {
        System.out.println("The list of students has changed: " + strings);
    }
}
