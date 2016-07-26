package aop.seller;

import org.aspectj.lang.ProceedingJoinPoint;
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

    // Handling returned value with @AfterReturning Annotation
    @AfterReturning(value = "clientGoShopping()",returning = "returnValue")
    public void shoppingResult(int returnValue){
        System.out.println("Seller got paid " + returnValue + "$. Is it more than 100$ ? " + (returnValue>100));
    }

    @AfterThrowing("clientGoShopping()")
    public void clientException(){
        System.out.println("Seller alerts that something went wrong.");
    }



    @Around("execution(** aop.client.Client.checkTime())")
    public void clientVisit(ProceedingJoinPoint proceedingJoinPoint){
        try {

            // TASKS BEFORE EXECUTING OF METHODQ
            System.out.println("Client is going to check the time...");

            proceedingJoinPoint.proceed();

            System.out.println("Client checked the time.");

            // TASKS AFTER EXECUTING OF METHOD

        } catch (Throwable throwable) {
            System.out.println("Visit went wrong.");
        }
    }

}
