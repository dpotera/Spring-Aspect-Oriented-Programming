package aop;

import aop.client.Client;
import aop.client.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("app.properties")
public class appConfig {

    @Autowired
    Environment environment;

    @Bean(name = "client")
    public Client newClient(){
        return new ClientImpl(environment.getProperty("client.name"));
    }

}
