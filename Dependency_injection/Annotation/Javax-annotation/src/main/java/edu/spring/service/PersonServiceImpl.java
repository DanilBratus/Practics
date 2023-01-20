package edu.spring.service;

import edu.spring.dao.PersonDao;
import edu.spring.domain.Person;
import edu.spring.service.annotation.Platform;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class PersonServiceImpl implements PersonService {
//  @Resource
    private final PersonDao dao;

    @Inject
    @Platform(Platform.Name.DIMPLE)
    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
