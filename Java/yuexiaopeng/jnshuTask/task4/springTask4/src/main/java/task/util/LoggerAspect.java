package task.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    static Logger logger = Logger.getLogger(LoggerAspect.class);

    @Around(value = "execution(* com.yxpStu.controller.*.*(..))")
    public Object loggerController(ProceedingJoinPoint joinPoint) throws Throwable {
        //开始时间
        long startTime = System.currentTimeMillis();
        //程序执行
        Object object = joinPoint.proceed();
        //结束时间
        long endTime = System.currentTimeMillis();
        //程序执行时间
        logger.info("[" + joinPoint.getSignature().getName() + "] controller time is: " + (endTime - startTime) + " (ms)");
        return object;
    }

    @Around(value = "execution(* com.yxpStu.service.serviceImp.*.*(..))")
    public Object loggerService(ProceedingJoinPoint joinPoint) throws Throwable {
        //开始时间
        long startTime = System.currentTimeMillis();//开始时间
        //程序执行
        Object object = joinPoint.proceed();//程序执行
        //结束时间
        long endTime = System.currentTimeMillis();//结束执行
        //程序执行时间
        logger.info("[" + joinPoint.getSignature().getName() + "] visitDb time is: " + (endTime - startTime) + " (ms)");
        return object;
    }
}