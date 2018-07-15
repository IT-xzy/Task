package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;


public class LoggerTime {
    public Object logDB(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LogManager.getLogger(LoggerTime.class);
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("此次访问数据库用时："+(endTime-startTime)+"毫秒");
        return object;
    }
    public Object logCon(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LogManager.getLogger(LoggerTime.class);
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("此次访问Controller层用时："+(endTime-startTime)+"毫秒");
        return object;
    }
}
