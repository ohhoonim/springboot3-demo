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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* dev.ohhoonim.demo..*Service.*(..))")
    public void serviceExecution() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
        
    }

    @Before("postMapping()")
    public void beforePostMapping(JoinPoint joinPoint) {
        // here 
    }

    @After("serviceExecution()")
    public void afterService() {
        // here 
    }

    @AfterReturning(pointcut = "serviceExecution()", returning = "result")
    public void afterReturningService(JoinPoint joinPoint, Object result) {
        // here
    }

    @Around("serviceExecution()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    @AfterThrowing(pointcut = "serviceExecution()", throwing = "ex")
    public void afterThrowingService(JoinPoint joinPoint, Throwable ex) throws Throwable {
        // here
    }
}
