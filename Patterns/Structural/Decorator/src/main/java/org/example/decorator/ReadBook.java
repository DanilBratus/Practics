package org.example.decorator;

public class ReadBook implements Read {
    @Override
    public void read() {
        System.out.println("Читаю книгу");
    }
}
