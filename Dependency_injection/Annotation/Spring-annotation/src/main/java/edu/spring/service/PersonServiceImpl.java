package edu.spring.service;

import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao dao;

    @Autowired
    public PersonServiceImpl(@Qualifier("personDao") PersonDao dao) {
        this.dao = dao;
    }

    @Lookup
    public PersonDao getDao() {
        return null;
    }

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
