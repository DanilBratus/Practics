package org.example.composite;

import org.example.composite.model.File;
import org.example.composite.model.Folder;

public class Application {
    public static void main(String[] args) {
        Folder myFolder = new Folder("Школа", "12.01.2000");
        myFolder.addFile(new File("Расписание"));
        myFolder.addFile(new File("Статистика"));
        myFolder.addFolder(new Folder("Математика", "12.10.2000"));

        System.out.println(myFolder);
    }
}
