package aop;

import aop.client.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class application {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();

        Client client = context.getBean(Client.class);
        client.goShopping();

    }

}
