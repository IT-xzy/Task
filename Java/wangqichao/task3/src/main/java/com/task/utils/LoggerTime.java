package com.task.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.apache.log4j.Logger;

public class LoggerTime {
    public Object logDb(ProceedingJoinPoint joinPoint) throws Throwable{
         Logger logger=Logger.getLogger(LoggerTime.class);
        long startTime=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("此次访问数据库用时："+(endTime-startTime)+"毫秒");
        return object;
    }
    public Object logCon(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger=Logger.getLogger(LoggerTime.class);
        long startTime=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("此次访问Controller层用时："+(endTime-startTime)+"毫秒");
        return object;
    }
}
