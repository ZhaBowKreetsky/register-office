package register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import register.dao.PersonDao;

@Configuration
@PropertySource(value = {"classpath:/register.properties"})
public class MarriageConfig {

    @Bean
    public PersonDao buildPersonDao() {
        System.out.println("PersonDao is created");
        return new PersonDao();
    }
}
