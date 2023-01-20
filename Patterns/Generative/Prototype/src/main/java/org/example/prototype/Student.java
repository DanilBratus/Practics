package org.example.prototype;

// Класс Student и является Prototype так как имплементация от Cloneable
public class Student implements Cloneable {
    protected String name = "Danil";
// Переопределяется метод clone() для нашего класса
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

// в этом классе хранится объект класса студента
class Cash {
    private Student student;
    public Cash(Student student) {
        this.student = student;
    }
// в этом методе хранимый объект клонируются
    public Student getStudent() throws CloneNotSupportedException {
        return this.student.clone();
    }
// в этом методе объект студента перезаписывается
    public void setStudent(Student student) {
        this.student = student;
    }
}
// в общем pattern PROTOTYPE необходим:
    // 1. Если в БД большой объект, и чтобы каждый раз его не вытягивать (один раз вытягивается, а после всегда клонируются)
    // 2. Если мы не хотим сразу же изменять наш первоначальный объект класса student (так мы изменяем клон, а после перезаписываем)
    // 3. Так же есть реализация для изображений
