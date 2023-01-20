package org.example.bridge.notebook.model;

import org.example.bridge.notebook.ColorNotebook;

public class HP extends Notebook {

    public HP(ColorNotebook colorNotebook) {
        super(colorNotebook);
    }

    @Override
    public void modelNotebook() {
        System.out.println("Модель: HP");
        colorNotebook.color();
    }
}
