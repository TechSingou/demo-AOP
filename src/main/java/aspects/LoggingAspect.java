package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        System.out.println("logger ok");
        logger.setUseParentHandlers(false);
    }

    long t1, t2;

    // PointCut pour les methodes des classes du package metier
    @Pointcut("execution(* metier.MetierBanqueImpl.*(..))")
    public void pc1() {
    }


    @Before("pc1()")
    public void avant(JoinPoint joinPoint) {
        t1 = System.currentTimeMillis();
        logger.info("------------------------------------------------------------");
        logger.info("Avant l'exécution de la methode " + joinPoint.getSignature());
    }

    @After("pc1()")
    public void pres(JoinPoint joinPoint) {
        logger.info("Après l'exécution de la methode " + joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("Durrée d'exécution de la méthode " + (t2 - t1));
        logger.info("------------------------------------------------------------");
    }
}
