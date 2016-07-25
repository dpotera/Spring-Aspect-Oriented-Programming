package aop;

import aop.client.*;
import aop.seller.Seller;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@ComponentScan
// Enable creating automatic proxy objects
@EnableAspectJAutoProxy
@PropertySource("app.properties")
public class ShopConfig {

    @Autowired
    Environment environment;

    @Bean(name = "client")
    public Client newClient(){
        return new ClientImpl(environment.getProperty("client.name"));
    }

    @Bean(name = "seller")
    public Seller seller(){
        return new Seller();
    }

    @Bean
    public ElemsList clientsList(){
        ArrayList<String> list = new ArrayList<String>();
        String[] names = {"Dominik","Daria","Adam","Wojtek","Piotr","Karolina","Mateusz","Sebastian","Mikolaj"};
        for(String name:names)
            list.add(name);

        return new ClientsList(list);
    }

    @Bean
    public ClientsMonitor clientsMonitor(){
        return new ClientsMonitor();
    }


}
