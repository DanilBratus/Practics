package edu.spring.dao;

import edu.spring.domain.Person;

public class PersonDaoDimple implements PersonDao{
    @Override
    public Person findByName(String name) {
        return new Person(name, 23);
    }
}
