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
public class LogInterceptorJDBC {
    private final Logger logger = (Logger) LoggerFactory.getLogger(LogInterceptorJDBC.class);
    long startTime,endTime,alltime;
    @Before(value = "execution(* com.mapper.StudentMapper.*(..))")
    public void before(){
        this.startTime=System.currentTimeMillis();
    }
    @After(value = "execution(* com.mapper.StudentMapper.*(..))")
    public void after(JoinPoint joinPoint){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String name = joinPoint.getSignature().getName();
        this.endTime=System.currentTimeMillis();
        this.alltime=this.endTime - this.startTime;
        logger.info("["+ df.format(new Date()) + "]" + name +"DB耗时(ms):" + this.alltime);
    }
}