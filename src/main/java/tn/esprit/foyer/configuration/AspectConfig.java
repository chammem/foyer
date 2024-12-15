package tn.esprit.foyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class AspectConfig {
    @After("execution(* tn.esprit.foyer.service.*.*(..))")
    @Before("execution(* tn.esprit.foyer.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
}
    @Around("execution(* tn.esprit.foyer.service.*.*(String,..)) throws Exception")
    void perfermance(ProceedingJoinPoint pjp) throws Throwable
    {
        LocalDateTime debut = LocalDateTime.now();
        Object o= pjp.proceed();
        LocalDateTime fin = LocalDateTime.now();
        long duree=(fin.getSecond()-debut.getSecond());
        log.info("temp execution : "+duree);
    }

}
