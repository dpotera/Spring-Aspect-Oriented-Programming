package aop.client.partner;

import org.aspectj.lang.annotation.*;

@Aspect
public class ClientPartnerAspect {

    @Pointcut("execution(* aop.client.Client.goShopping(..))")
    public void clientIsGoingShopping(){}

    @Before("clientIsGoingShopping()")
    public void addClientPartner(){
        System.out.println(clientPartner.assistShopping());
    }

    @After("clientIsGoingShopping()")
    public void returnWithClient(){
        System.out.println(clientPartner.assistShopping());
    }

    private ClientPartner clientPartner;
    public void setClientPartner(ClientPartner clientPartner){
        this.clientPartner = clientPartner;
    }

}
