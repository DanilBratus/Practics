package edu.spring.dao;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class NameBD implements MethodReplacer {
    public static String name = "Person BD";

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Replace method...");
        return method.invoke(o,objects);
    }
}
