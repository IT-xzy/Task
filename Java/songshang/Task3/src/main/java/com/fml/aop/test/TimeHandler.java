package com.fml.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeHandler {

    @Around("execution(* com.fml.aop.test.HelloWorld.*(..))")
    public void printTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("CurrentTime = " + System.currentTimeMillis());
            joinPoint.proceed();
            System.out.println("CurrentTime = " + System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
