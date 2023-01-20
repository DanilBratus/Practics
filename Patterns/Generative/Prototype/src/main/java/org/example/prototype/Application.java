package org.example.prototype;

public class Application {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash(new Student());
        Student clone = cash.getStudent();
        System.out.println(clone);
// Ведется работа с клоном
        clone.name = "Adolf";
        cash.setStudent(clone);
        System.out.println(clone);
// Происходит перезапись обьекта
    }
}
