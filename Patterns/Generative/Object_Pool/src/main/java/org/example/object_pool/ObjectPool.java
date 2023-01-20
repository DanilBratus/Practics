package org.example.object_pool;

import java.util.LinkedList;
import java.util.List;

// паттерн ObjectPool своего рода является бассейном, где находятся элементы, и мы их перекидываем с помощью методов.
class ObjectPool {
    // Реализация структуры данных может быть разной
    List<MyClass> free = new LinkedList<>();
    List<MyClass> used = new LinkedList<>();

    public MyClass getMyClass() {
        if (free.isEmpty()) {
            MyClass mc = new MyClass();
            free.add(mc);
            return mc;
        } else {
            MyClass mc = free.get(0);
            used.add(mc);
            free.remove(mc);
            return mc;
        }
    }

    public void releaseMyClass(MyClass myClass) {
        used.remove(myClass);
        free.add(myClass);
    }
}
