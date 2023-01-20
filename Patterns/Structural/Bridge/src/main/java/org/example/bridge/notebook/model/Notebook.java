package org.example.bridge.notebook.model;

import org.example.bridge.notebook.ColorNotebook;

public abstract class Notebook {
    ColorNotebook colorNotebook;

    public Notebook(ColorNotebook colorNotebook) {
        this.colorNotebook = colorNotebook;
    }

    public abstract void modelNotebook();
}
