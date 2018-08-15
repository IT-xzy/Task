package com.Logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "logger")
@Aspect
public class LogInterceptor {

    private final Logger logger=Logger.getLogger(LogInterceptor.class);
    private long dBStartTime,dBEndTime;

    //配置切面方法
    @Pointcut("execution(* com.service.impl.UserServiceImpl.*(..))")
    public void serviceAddUser(){
    }

    //获得DB层方法开始时的时间戳
    @Before("serviceAddUser()")
    public void serviceAddUserBefore(){
        dBStartTime=System.currentTimeMillis();
    }

    //获得DB层方法结束时的时间戳，并通过减去DB层方法开始的时间戳获得方法的执行时间
    @After("serviceAddUser()")
    public void serviceAddUserAfter(JoinPoint joinPoint){
        //注释
        dBEndTime=System.currentTimeMillis();
        logger.info("DB:"+joinPoint.getSignature().getName()+":"+(dBEndTime-dBStartTime)+"ms");
    }

}
