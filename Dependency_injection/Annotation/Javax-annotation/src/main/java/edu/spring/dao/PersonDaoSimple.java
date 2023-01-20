package edu.spring.dao;

import edu.spring.domain.Person;
import edu.spring.service.annotation.Platform;

import javax.inject.Named;

@Named("personDaoSimple")
@Platform(Platform.Name.SIMPLE) // extends @Qualifier
public class PersonDaoSimple implements PersonDao {

    @Override
    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
