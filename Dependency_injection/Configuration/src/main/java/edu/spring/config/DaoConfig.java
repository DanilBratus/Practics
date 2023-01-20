package edu.spring.config;

import edu.spring.dao.PersonDao;
import edu.spring.dao.PersonDaoDimple;
import edu.spring.dao.PersonDaoSimple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DaoConfig {

    @Lazy(value = true)
    @Scope("prototype")
    @Bean(name = "personDAO", initMethod = "init", destroyMethod = "destroy")
    public PersonDao personDaoS() {
        return new PersonDaoSimple();
    }


    @Primary
    @Bean
    public PersonDao personDaoD() {
        return new PersonDaoDimple();
    }
}
