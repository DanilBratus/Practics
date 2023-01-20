package org.example.composite.model;

import java.util.ArrayList;
import java.util.List;
// Класс Folder является композитным объектом т.к. содержит сам себя
public class Folder {
    String nameFolder;
    String dataFolder;
    List<Folder> folders = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public Folder(String nameFolder, String dataFolder) {
        this.nameFolder = nameFolder;
        this.dataFolder = dataFolder;
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }
    public void removeFolder(Folder folder) {
        folders.remove(folder);
    }
    public List<Folder> getFolders() {
        return folders;
    }

    public void addFile(File file) {
        files.add(file);
    }
    public void removeFile(File file) {
        files.remove(file);
    }
    public List<File> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "nameFolder='" + nameFolder + '\'' +
                ", dataFolder='" + dataFolder + '\'' +
                ",\n\t folders=" + folders +
                ",\n\t files=" + files +
                '}';
    }
}
