package com.pojo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogInterceptor {
    private final Logger logger = (Logger) LoggerFactory.getLogger(LogInterceptor.class);
    long startTime,endTime,allTime;
    @Before(value = "execution(* com.controller.*.*(..))")
    public void before(){
        this.startTime=System.currentTimeMillis();
    }
    @After(value = "execution(* com.controller.*.*(..))")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.endTime=System.currentTimeMillis();
        this.allTime = this.endTime-this.startTime;
        logger.info("[" + df.format(new Date()) + "]"+ name +"Controller耗时(ms):" + this.allTime);
    }
}
