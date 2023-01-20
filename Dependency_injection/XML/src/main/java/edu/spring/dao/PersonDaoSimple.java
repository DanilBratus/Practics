package edu.spring.dao;

import edu.spring.domain.Person;

public class PersonDaoSimple implements PersonDao {
    public String field;
    public Clazz clazz;
    public static NameBD nameBD = new NameBD();

    public NameBD createNameBDInstance() {
        return nameBD;
    }

    private PersonDaoSimple(String field, Clazz clazz) {
        this.field = field;
        this.clazz = clazz;
    }

    public static PersonDaoSimple createPersonDaoSimple(String field, Clazz clazz) {
        PersonDaoSimple pds = new PersonDaoSimple("field", new Clazz());
        return pds;
    }
    @Override
    public Person findByName(String name) {
        return new Person(name, 18);
    }

    @Override
    public void print() {
    }
}
