package com.ptteng;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/28  16:01
 * @Version 1.0
 **/

//让这个类被spring当作一个bean管理
@Component
//标明这个类是一个切面对象
@Aspect
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class);
//    execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
    @Around(value = "execution(public * com.ptteng.controller.*.*(..))")
    public Object timeFirst(ProceedingJoinPoint pjp) throws Throwable{
        long t1 = System.currentTimeMillis();
        Object[] arg = pjp.getArgs();
        String method = pjp.getSignature().getName();
        Object trage =pjp.getTarget();
//    调用 proceed() 方法才会真正的执行实际被代理的方法
        Object result =pjp.proceed();
        long t2 =System.currentTimeMillis();
        logger.info("响应时间==============================================="+(t2-t1));
        logger.info("方法名================================================="+method);
        return result;
    }


    @Around(value = "execution(public * com.ptteng.service.impl.*.*(..))")
    public Object timeSecond(ProceedingJoinPoint pjp) throws Throwable{
        long t3 = System.currentTimeMillis();
        Object[] arg = pjp.getArgs();
        String method = pjp.getSignature().getName();
        Object trage =pjp.getTarget();
        Object result =pjp.proceed();
        long t4 =System.currentTimeMillis();
        logger.info("访问数据库时间==============================================="+(t4-t3));
        logger.info("方法名================================================="+method);
        return result;
    }
}
