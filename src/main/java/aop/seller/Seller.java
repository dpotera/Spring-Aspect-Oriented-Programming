package aop.seller;

import org.aspectj.lang.annotation.*;

@Aspect
public class Seller {

    @Pointcut("execution(** aop.client.Client.goShopping(..))")
    public void clientGoShopping(){}

    @Before("clientGoShopping()")
    public void inviteClient(){
        System.out.println("Seller is inviting clients");
    }

    @After("clientGoShopping()")
    public void goodbyeClient(){
        System.out.println("Seller thanks for visit");
    }

    @AfterReturning(value = "clientGoShopping()",returning = "returnValue")
    public void shoppingResult(int returnValue){
        System.out.println("Seller got paid " + returnValue + "$. Is it more than 100$ ? " + (returnValue>100));
    }

    @AfterThrowing("clientGoShopping()")
    public void clientException(){
        System.out.println("Seller alerts that something went wrong.");
    }

}
