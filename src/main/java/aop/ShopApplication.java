package aop;

import aop.client.Client;
import aop.client.ClientsMonitor;
import aop.client.ElemsList;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ShopApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();

        Client client = context.getBean(Client.class);
        client.goShopping();
        client.checkTime();

        System.out.println('\n');

        ElemsList clientsList = context.getBean(ElemsList.class);
        try {
            clientsList.serveClient(1);
            clientsList.serveClient(2);
            clientsList.serveClient(2);
            clientsList.serveClient(3);
            clientsList.serveClient(3);
            clientsList.serveClient(3);
            clientsList.serveClient(3);
            clientsList.serveClient(5);
            clientsList.serveClient(5);
            clientsList.serveClient(7);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        ClientsMonitor clientsMonitor = context.getBean(ClientsMonitor.class);
        clientsMonitor.showClientsVisits();

        System.out.println('\n');



    }

}
