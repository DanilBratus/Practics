package org.example.composite.model;

public class File {
    String nameFile;

    public File(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public String toString() {
        return "File{" +
                "nameFile='" + nameFile + '\'' +
                '}';
    }
}
