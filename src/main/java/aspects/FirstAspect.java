package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class FirstAspect {
    @Pointcut("execution(* test.*.mai(..))")
    public void pc1() {
    }

    // First way

    @Before("pc1()")
    public void beforeMain() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Before main from Aspect with Class Syntax");
        System.out.println("-----------------------------------------------------");
    }

    @After("pc1()")
    public void afterMain() {
        System.out.println("-----------------------------------------------------");
        System.out.println("After main from Aspect with Class Syntax");
        System.out.println("-----------------------------------------------------");
    }


    // Second way
    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("-----------------------------------------------------");
        System.out.println("Before main from Aspect with Class Syntax");
        System.out.println("-----------------------------------------------------");

        //Exécuter la methode main
        proceedingJoinPoint.proceed();

        System.out.println("-----------------------------------------------------");
        System.out.println("After main from Aspect with Class Syntax");
        System.out.println("-----------------------------------------------------");
    }

}
