package com.mojorjoe.web.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class TimeLogger {


    /**
     * 记录访问数据库所发费的时间
     */

    public Object dataAccessTime(ProceedingJoinPoint joinPoint) throws Throwable {

        Logger logger=Logger.getLogger(TimeLogger.class);

        long startTime= System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long endTime= System.currentTimeMillis();

        logger.info("访问数据库发费时间："+(endTime-startTime));

        return object;
    }

    /**
     * 记录访问数据库所发费的时间
     */

    public Object controllerTime(ProceedingJoinPoint joinPoint) throws Throwable {

        Logger logger=Logger.getLogger(TimeLogger.class);

        long startTime= System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long endTime= System.currentTimeMillis();

        logger.info("Controller发费时间："+(endTime-startTime));

        return object;
    }





}
