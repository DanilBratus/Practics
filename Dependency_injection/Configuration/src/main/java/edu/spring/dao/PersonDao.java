package edu.spring.dao;

import edu.spring.domain.Person;

public interface PersonDao {

    Person findByName(String name);

    default void init() {
        System.out.println("Destroy method...");
    }

    default void destroy() {
        System.out.println("Init method...");
    }
}
