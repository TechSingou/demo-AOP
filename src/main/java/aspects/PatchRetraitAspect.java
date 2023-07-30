package aspects;

import metier.Compte;
import metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut("execution(* metier.MetierBanqueImpl.retirer(..))")
    public void myPc1() {
    }

    @Around("myPc1() && args(code, montant)")
    public Object autourRetirer(Long code, double montant, ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        MetierBanqueImpl metierBanque = (MetierBanqueImpl) joinPoint.getTarget();
        Compte compte = metierBanque.consulter(code);
        if (compte.getSole() < montant)
            throw new RuntimeException("Solde insuffissant");
        return proceedingJoinPoint.proceed();
    }
}
