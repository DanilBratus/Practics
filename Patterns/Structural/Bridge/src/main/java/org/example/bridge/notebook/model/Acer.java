package org.example.bridge.notebook.model;

import org.example.bridge.notebook.ColorNotebook;

public class Acer extends Notebook {

    public Acer(ColorNotebook colorNotebook) {
        super(colorNotebook);
    }

    @Override
    public void modelNotebook() {
        System.out.println("Модель: Acer");
        colorNotebook.color();
    }
}
