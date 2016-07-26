package aop.client;

import aop.ShopConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShopConfig.class)
public class ClientImplTest {

    @Autowired
    Client client;

    @Test
    public void goShoppingReturnedRandomRange()  {
        int result = client.goShopping();
        assertTrue(result>0 && result<200);
    }

}