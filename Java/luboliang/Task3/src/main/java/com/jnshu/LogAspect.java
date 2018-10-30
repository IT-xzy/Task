package com.jnshu;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component//加入IOC容器
@Aspect//表示这是一个切面类
public class LogAspect {
    protected Logger log = Logger.getLogger(LogAspect.class);

    @Around(value = "execution(public * com.jnshu.controller.*.*(..))")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        //调用方法的参数
        Object[] args = pjp.getArgs();
        //调用的方法名
        String method = pjp.getSignature().getName();
        //获取目标对象
        Object trage = pjp.getTarget();
        //执行完方法的返回值
        //调用proceed（）方法，就会出发切入点方法执行
        Object result = pjp.proceed();
        Long T2 = System.currentTimeMillis();
        log.info("响应时间=========================================================================" +
                "=============================" + (T2 - t1));
        //打印方法名字
        log.info("=============方法名==========================================="+method);
       return result;
    }
    @Around(value = "execution(public * com.jnshu.mapper.*.*(..))")
    public Object time1(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        //调用方法的参数
        Object[] args = pjp.getArgs();
        //调用的方法名
        String method = pjp.getSignature().getName();
        //获取目标对象
        Object trage = pjp.getTarget();
        //执行完方法的返回值
        //调用proceed（）方法，就会出发切入点方法执行
        Object result = pjp.proceed();
        Long T2 = System.currentTimeMillis();
        log.info("访问DB时间=========================================================================" +
                "=============================" + (T2 - t1));
        //打印方法名字
        log.info("=============方法名==========================================="+method);
        return result;
    }
}

