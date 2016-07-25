package aop;

import aop.client.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ShopApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();

        Client client = context.getBean(Client.class);
        client.goShopping();
        client.checkTime();

    }

}
