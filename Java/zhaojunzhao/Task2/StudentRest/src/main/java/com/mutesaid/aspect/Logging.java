package com.mutesaid.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    @Pointcut("execution(* com.mutesaid.service.StudentService.*(..))")
    public void serviceAspect(){}

    @Around(value = "serviceAspect()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Logger logger = LogManager.getLogger(pjp.getTarget());
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();

        logger.info("开始执行{}的{}方法",className,methodName);

        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("返回值是{}，执行时间{}ms",obj,endTime-startTime);

        return obj;
    }
}
