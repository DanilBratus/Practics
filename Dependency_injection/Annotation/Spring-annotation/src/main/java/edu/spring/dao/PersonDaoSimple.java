package edu.spring.dao;

import edu.spring.domain.Person;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("personDao")
@Scope("prototype")
public class PersonDaoSimple implements PersonDao {
    @Value("My value group")
    private String group;

    @Required
    public void setGroup(@Value("My required group")String f) {
        this.group = f;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
