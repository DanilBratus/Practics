package edu.spring.dao;

import edu.spring.domain.Person;
import edu.spring.service.annotation.Platform;

import javax.inject.Named;

@Named
@Platform(Platform.Name.DIMPLE) // extends @Qualifier
public class PersonDaoDimple implements PersonDao {

    @Override
    public Person findByName(String name) {
        return new Person(name, 23);
    }
}
