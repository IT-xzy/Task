package com.task2.aspectJ;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;


public class TimeInterceptor {
    Logger logger = Logger.getLogger(TimeInterceptor.class);
    long start;
    long end;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //    环绕通知

    public Object doAroundDB(ProceedingJoinPoint joinPoint) {
        start = System.currentTimeMillis();
        Object result = null;

        try {
            //        前置通知
            System.out.println("方法开始执行时间：" + simpleDateFormat.format(start));
//           执行目标方法
            System.out.println("目标方法名:" + joinPoint.getSignature().getName());
            result = joinPoint.proceed();


        } catch (Throwable e) {
            //异常通知
            System.out.println("The method: " + "异常通知： " + e.getMessage());
        }
        end = System.currentTimeMillis();
//            后置通知
        System.out.println("执行方法总用时：" + (end - start));
        logger.info("DB方法名:" + joinPoint.getSignature().getName()+"\'" + "DB执行方法总用时：" + (end - start));
        return result;
    }

    public Object doAroundCT(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        start = System.currentTimeMillis();
      Object result;


        //        前置通知
        System.out.println("方法开始执行时间：" + simpleDateFormat.format(start));
//           执行目标方法
        System.out.println("目标方法名:" + proceedingJoinPoint.getSignature().getName());
        result = proceedingJoinPoint.proceed();


        end = System.currentTimeMillis();
//            后置通知
        System.out.println( "执行方法总用时：" + (end - start));
        logger.info("CT方法名:" + proceedingJoinPoint.getSignature().getName()+"\'" +"Controller执行方法总用时：" + (end - start));
        return result;

    }
}
