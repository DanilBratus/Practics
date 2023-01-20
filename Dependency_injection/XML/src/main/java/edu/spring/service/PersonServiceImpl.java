package edu.spring.service;

import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;
import org.springframework.beans.factory.annotation.Required;

public class PersonServiceImpl implements PersonService {
    private int number;
    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao, int number) {
        this.number = number;
        this.dao = dao;
    }

    @Required
    public void setNumber(int number) {
        System.out.println("Required ...");
        this.number = number;
    }

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }

    private void destroy() {
        System.out.println("Destroy");
    }

    private void init() {
        System.out.println("Init");
    }
}
