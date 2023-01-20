package org.example.object_pool;

public class Application {
    public static void main(String[] args) {
        ObjectPool op = new ObjectPool();
        MyClass mc = op.getMyClass();
        op.releaseMyClass(mc);
    }
}