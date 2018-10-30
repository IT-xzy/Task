package com.springAOP2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advices2 {


    @Before("execution(* com.springAOP2.MyMath2.*(..))")
    public void Before(JoinPoint jp){
       System.out.println("-----前置通知-----");
        System.out.println(jp.getSignature().getName());
   }

    @After("execution(* com.springAOP2.MyMath2.*(..))")
    public void After(JoinPoint jp){
        System.out.println("-----后置通知-----");
    }

}
