package com.ptteng.aspect;



import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Interceptor {

    static Logger logger = Logger.getLogger(Interceptor.class);

    @Pointcut("execution(* com.ptteng.controller.*.*(..))||execution(* com.ptteng.service.*.*(..))")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed(joinPoint.getArgs());
        long end = System.currentTimeMillis();
        logger.info(joinPoint.getSignature() + "方法执行时间" + (end - start) + "毫秒");
        return object;
    }

}
