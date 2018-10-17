package com.lihoo.ssm.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * #Title: LogAspect
 * #ProjectName task4_index3
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/24-20:55
 */

@Aspect
@Component
public class LogAspect {
    private static Logger logger = LogManager.getLogger(LogAspect.class);


    //
//    Pointcut 定义切点：StudentController中所有方法
    @Pointcut(value = "execution(* com.lihoo.ssm.service.impl.*.*(..))")
    public void serviceAspect() {
    }

    //    joinPoint连接点
    @Around(value = "serviceAspect()")
    public Object around1(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("开始计算数据库响应时间service");
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

        logger.info(msg + "\t数据库响应时间：" + sqlTime + "ms");
        return obj;
    }


    //
//    Pointcut 定义切点：StudentController中所有方法
    @Pointcut(value = "execution(* com.lihoo.ssm.controller.*.*(..))")
    public void controlAspect() {
    }

    //    joinPoint连接点
    @Around(value = "controlAspect()")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("开始计算数据库响应时间control");
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

        logger.info(msg + "\t数据库响应时间：" + sqlTime + "ms");
        return obj;
    }
}
