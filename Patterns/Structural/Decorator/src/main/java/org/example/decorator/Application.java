package org.example.decorator;

public class Application {
    public static void main(String[] args) {
        Read readBook = new ReadBookWithAnnotation(new ReadBook());
        readBook.read();
    }
}
