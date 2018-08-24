package com.zyq.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@Aspect
public class LogInterceptor {
    private final Logger logger = LogManager.getLogger(LogInterceptor.class);

    @Around("execution(* com.zyq.controller.*.*(..))")
    public Object processLog(ProceedingJoinPoint joinPoint)  {
        return logPrint(joinPoint);
    }

    @Around("execution(* com.zyq.service.impl.*.*(..))")
    public Object processLogService(ProceedingJoinPoint joinPoint)  {
        return logPrint(joinPoint);
    }

    public Object logPrint(ProceedingJoinPoint joinPoint){
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error(getMethodName(joinPoint)+"统计某方法执行耗时环绕通知出错", e);
        }
        long endTime = System.currentTimeMillis();
        this.printExecTime(getMethodName(joinPoint), startTime, endTime);
        return obj;
    }

    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.debug( methodName + " 方法执行耗时： " + diffTime + " ms");
    }

    private String getMethodName(JoinPoint joinPoint){
        return joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName();
    }
}

