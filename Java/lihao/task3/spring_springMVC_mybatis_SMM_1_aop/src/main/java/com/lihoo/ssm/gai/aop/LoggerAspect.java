package com.lihoo.ssm.gai.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * #Title: AspectController
 * #ProjectName spring_springMVC_mybatis_SMM_1 - aop
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/20-19:20
 */

@Aspect
@Component
public class LoggerAspect {
    private static Logger logger = Logger.getLogger(LoggerAspect.class);

//    @Around(value = "execution(* com.lihoo.ssm.gai.service.Impl.*.*(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        logger.debug("start：" + pjp.getSignature().getName());
//        Object obj = pjp.proceed();
//        logger.debug("end：" + pjp.getSignature().getName());
//        long endTime = System.currentTimeMillis();
//        logger.debug("Time is ：" + (endTime - startTime) + "ms");
//        return obj;
//    }
//
//
//    @Around(value = "execution(* com.lihoo.ssm.gai.controller.*.*(..))")
//    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        logger.debug("Controller开始处理：" + pjp.getSignature().getName());
//        Object obj = pjp.proceed();
//        logger.debug("Controller处理结束：" + pjp.getSignature().getName());
//        long endTime = System.currentTimeMillis();
//        logger.debug("Controller 处理时间为 ：" + (endTime - startTime) + "ms");
//        return obj;
//    }



//
//    Pointcut 定义切点：StudentController中所有方法
    @Pointcut(value = "execution(* com.lihoo.ssm.gai.service.Impl.*.*(..))")
    public void serviceAspect() {
    }

//    joinPoint连接点
    @Around(value = "serviceAspect()")
    public Object around3(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("开始切面");
//        获取组件类名
        String className = pjp.getTarget().getClass().getName();
//        获取调用方法名
        String method = pjp.getSignature().getName();
//        取得数据库连接之前的时间
        long start_conn = System.currentTimeMillis();
//        当前系统时间
        String date = new SimpleDateFormat("yyyy-MM-dd:mm:ss").format(new Date());
        Object obj = pjp.proceed();

//        取得数据库链接之后时间
        long end_conn = System.currentTimeMillis();
//        数据库响应时间
        int sqlTime = (int) (end_conn - start_conn);
        String msg = date + ",执行了" + className +"." + method +"()";

        logger.debug(msg + "\t数据库响应时间：" + sqlTime + "ms");
        return obj;
    }


    //
//    Pointcut 定义切点：StudentController中所有方法
    @Pointcut(value = "execution(* com.lihoo.ssm.gai.controller.*.*(..))")
    public void controlAspect() {
    }

    //    joinPoint连接点
    @Around(value = "controlAspect()")
    public Object around4(ProceedingJoinPoint pjp) throws Throwable {
//        logger.debug("开始切面");
//        获取组件类名
        String className = pjp.getTarget().getClass().getName();
//        获取调用方法名
        String method = pjp.getSignature().getName();
//        取得数据库连接之前的时间
        long start_conn = System.currentTimeMillis();
//        当前系统时间
        String date = new SimpleDateFormat("yyyy-MM-dd:mm:ss").format(new Date());
        Object obj = pjp.proceed();

//        取得数据库链接之后时间
        long end_conn = System.currentTimeMillis();
//        数据库响应时间
        int sqlTime = (int) (end_conn - start_conn);
        String msg = date + ",执行了" + className +"." + method +"()";

        logger.debug(msg + "\t数据库响应时间：" + sqlTime + "ms");
        return obj;
    }



}
