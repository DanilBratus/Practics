package org.example.decorator;

public class ReadBookWithAnnotation extends Decorator{
    public ReadBookWithAnnotation(Read read) {
        super(read);
    }

    @Override
    public void read() {
        read.read();
        System.out.println("Делаю пометки");
    }
}
