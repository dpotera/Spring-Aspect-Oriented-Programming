package aop;

import aop.client.Client;
import aop.client.ClientImpl;
import aop.seller.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

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

}
