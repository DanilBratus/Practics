package org.example.bridge;

import org.example.bridge.notebook.model.Notebook;
import org.example.bridge.notebook.color.Black;
import org.example.bridge.notebook.color.Grey;
import org.example.bridge.notebook.model.Acer;
import org.example.bridge.notebook.model.HP;

public class Application {
    public static void main(String[] args) {
        Notebook hp = new HP(new Grey());
        hp.modelNotebook();
        Notebook acer = new Acer(new Black());
        acer.modelNotebook();
    }
}