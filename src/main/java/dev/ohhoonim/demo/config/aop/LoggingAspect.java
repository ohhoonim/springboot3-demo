package dev.ohhoonim.demo.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* dev.ohhoonim.demo.service..*.*Service.*(..))")
    public void serviceExecution() {
        log.debug("{}", "service method log...");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
        log.debug("{}", "post mapping log...");
    }

    @Before("postMapping()")
    public void beforePostMapping() {
        log.debug("{}", "before post mapping...")
    }

    @After("serviceExecution()")
    public void afterService() {
        log.debug("{}", "after post mapping...")
    }

    @AfterReturning(pointcut = "serviceExecution()", returning = "result")
    public void afterReturningService(JoinPoint joinPoint, Object result) {

    }

    @Around("serviceExecution()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    @AfterThrowing(pointcut = "serviceExecution()", throwing = "ex")
    public void afterThrowingService(JoinPoint joinPoint, Throwable ex) throws Throwable {

    }
}
