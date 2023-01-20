package org.example.bridge.notebook.color;

import org.example.bridge.notebook.ColorNotebook;

public class Grey implements ColorNotebook {
    @Override
    public void color() {
        System.out.println("Цвет: серый");
    }
}
