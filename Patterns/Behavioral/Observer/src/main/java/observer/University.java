package observer;

import java.util.ArrayList;
import java.util.List;

class University {
    private final List<Observer> observers = new ArrayList<>();
    private final List<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
        notifyObservers();
    }
    public void removeStudent(String name) {
        students.remove(name);
        notifyObservers();
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.event(students);
        }
    }
}
