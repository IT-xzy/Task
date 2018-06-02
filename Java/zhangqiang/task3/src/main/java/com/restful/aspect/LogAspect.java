package com.restful.aspect;

import com.restful.service.RandomStudent;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LogAspect {

    static Logger logger = Logger.getLogger(LogAspect.class);
    private long startTime;
    private long endTime;
    private String runTime;
    private Date date = new Date();
    private RandomStudent randomStudent = new RandomStudent();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日HH时mm分ss秒");


    @Test
    public void test() throws InterruptedException {

        startTime = System.currentTimeMillis();
        Thread.sleep(124);
        endTime = System.currentTimeMillis();

        String runtime = randomStudent.getDistanceTime(startTime,endTime);

        logger.info(runtime);
    }


//    @Pointcut("execution(* com.restful.controller.RestController.*(..))")
    public Object dbLog(ProceedingJoinPoint joinPoint) throws Throwable {

        runTime = simpleDateFormat.format(date.getTime());

        startTime = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        endTime = System.currentTimeMillis();

        String runtime =  randomStudent.getDistanceTime(startTime,endTime);

        logger.info(runTime + " 访问数据库用时：" + runtime);

        return object;

    }

    public Object ControllerLog(ProceedingJoinPoint joinPoint) throws Throwable {

        runTime = simpleDateFormat.format(date.getTime());

        startTime = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        endTime = System.currentTimeMillis();

        String runtime =  randomStudent.getDistanceTime(startTime,endTime);

        logger.info(runTime + " 访问RestController用时：" + runtime);

        return object;

    }

}
