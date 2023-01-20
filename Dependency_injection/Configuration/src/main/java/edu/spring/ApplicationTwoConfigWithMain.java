package edu.spring;

import edu.spring.config.ServicesConfig;
import edu.spring.domain.Person;
import edu.spring.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTwoConfigWithMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class);

        PersonService service = context.getBean(PersonService.class);

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
