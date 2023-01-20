package edu.spring.config;

import edu.spring.dao.PersonDao;
import edu.spring.service.ConditionService;
import edu.spring.service.PersonService;
import edu.spring.service.PersonServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("edu.spring.config")
@Import(DaoConfig.class)
@Conditional(ConditionService.class)
public class ServicesConfig {

    @Bean("personService")
    @DependsOn("personDAO")
    @Description("Главный бин personService")
    @Role(BeanDefinition.ROLE_APPLICATION)
    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
