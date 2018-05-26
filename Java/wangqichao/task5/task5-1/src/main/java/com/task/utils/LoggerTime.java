package com.task.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP用日志切面
 */
public class LoggerTime {
    /**
     * 对访问数据库的所有方法进行日志切面
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object logDb(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger=Logger.getLogger(LoggerTime.class);
        long startTime=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("此次访问数据库用时："+(endTime-startTime)+"毫秒");
        return object;
    }
    /**
     * 对controller层的所有方法进行日志切面
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object logCon(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger=Logger.getLogger(LoggerTime.class);
        long startTime=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("此次访问Controller层用时："+(endTime-startTime)+"毫秒");
        return object;
    }
}
