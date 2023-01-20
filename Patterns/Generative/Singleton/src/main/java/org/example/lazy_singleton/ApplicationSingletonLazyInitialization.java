package org.example.lazy_singleton;

public class ApplicationSingletonLazyInitialization {
    public static void main(String[] args) {
        SingletonLazyInitialization singletonLazy = SingletonLazyInitialization.instance();
        System.out.println(singletonLazy);
    }
}

class SingletonLazyInitialization {
    private static SingletonLazyInitialization singletonLazyInitialization;

    private SingletonLazyInitialization() {
    }

    public static SingletonLazyInitialization instance() {
        if (singletonLazyInitialization == null) {
            singletonLazyInitialization = new SingletonLazyInitialization();
        }
        return singletonLazyInitialization;
    }
}
