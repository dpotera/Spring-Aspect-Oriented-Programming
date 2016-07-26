package aop;

import aop.client.ClientsMonitor;
import aop.client.ElemsList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShopConfig.class)
public class ShopConfigTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule();

    @Autowired
    ElemsList clientsList;

    @Autowired
    ClientsMonitor clientsMonitor;

    @Test
    public void clientsMonitorCountsClients(){
        clientsList.serveClient(0);
        clientsList.serveClient(0);
        clientsList.serveClient(1);
        clientsList.serveClient(3);
        clientsList.serveClient(3);
        clientsList.serveClient(3);
        clientsList.serveClient(3);
        clientsList.serveClient(5);
        clientsList.serveClient(5);
        clientsList.serveClient(6);

        assertEquals(2, clientsMonitor.getClientVisits(0));
        assertEquals(1, clientsMonitor.getClientVisits(1));
        assertEquals(0, clientsMonitor.getClientVisits(2));
        assertEquals(4, clientsMonitor.getClientVisits(3));
        assertEquals(0, clientsMonitor.getClientVisits(4));
        assertEquals(2, clientsMonitor.getClientVisits(5));
        assertEquals(1, clientsMonitor.getClientVisits(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void clientsServeException() throws IllegalArgumentException{
        clientsList.serveClient(clientsList.getClientsNumber());
    }



}