package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ComponentScan;

//@ComponentScan(basePackage = "com.project")
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext("com.project");
        applicationContext.close();
    }
}
