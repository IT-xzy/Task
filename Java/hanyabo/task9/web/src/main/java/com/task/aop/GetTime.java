package com.task.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GetTime {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public Object logBase(ProceedingJoinPoint joinPoint, String name) throws Throwable{
        long t= System.currentTimeMillis();
        Object object=joinPoint.proceed();
        t = System.currentTimeMillis()-t;
        logger.info("------------------"+name+" "+joinPoint.getSignature().getName()+" runtime "+t);
        return object;
    }

    @Around(value="execution(* com.task.controller.StudentController.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable{
        return logBase(joinPoint,"controller");
    }

//    @Around(value="execution(* com.task.service.impl.StudentServiceImpl.*(..))")
//    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable{
//        return logBase(joinPoint,"database");
//    }

}
