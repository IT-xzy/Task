package com.myitschool.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
    //java自带的log日志
    private final Logger logger = Logger.getLogger("DB_Controller");

    @Pointcut("execution(* com.myitschool.controller.*.*(..))")
    private void controller(){}

    @Around("controller()")
    public Object controllerTime(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getSignature().getName();
        long startT = System.currentTimeMillis();
        Object re = pjp.proceed();
        long time = System.currentTimeMillis() - startT;
        logger.info(logger.getName() + " " + className + " " + time);
        System.out.println(logger.getName() + " " + className + " " + time);
        return re; //有返回值必须
    }

}
