package edu.spring;

import edu.spring.dao.PersonDaoSimple;
import edu.spring.domain.Person;
import edu.spring.service.PersonServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.spring")
public class ApplicationTwoConfigWithMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationTwoConfigWithMain.class);

        PersonServiceImpl service = context.getBean(PersonServiceImpl.class);
        System.out.println(service.getDao());

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());

        PersonDaoSimple dao = context.getBean(PersonDaoSimple.class);
        System.out.println(dao.getGroup());
        dao.setGroup(null);
        System.out.println(dao.getGroup());
    }
}
