package org.example.decorator;

// Это то же самое что и Bridge(Мост) только объект создается от интерфейса, а не от
// абстрактного класса
abstract class Decorator implements Read {
    Read read;

    public Decorator(Read read) {
        this.read = read;
    }
    @Override
    public abstract void read();
}
