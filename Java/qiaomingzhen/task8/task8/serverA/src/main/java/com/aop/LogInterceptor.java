package com.aop;
/*
 * @ClassName:LogInterceptor
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/20 17:56
 **/

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    private final Logger logger = Logger.getLogger(LogInterceptor.class);

    @Around("execution(* com.controller..*.*(..))")
    public Object processLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        obj = joinPoint.proceed(args);
        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        // 打印耗时的信息
        logger.info("1 " + "执行方法名：" + methodName + "||" + "方法执行时间 " + time);
        return obj;
    }

    @Around("execution(* com.service..*.*(..))")
    public Object serviceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        obj = joinPoint.proceed(args);

        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        // 打印耗时的信息
        logger.info("2 " + "执行方法名：" + methodName + "||" + "访问DB执行时间 " + time);
        return obj;
    }
}
