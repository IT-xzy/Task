package com.jns.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //注解表示这是一个切面
@Component //表示这是一个bean,由Spring进行管理
public class LoggerAspect {
    Logger logger= LoggerFactory.getLogger(LoggerAspect.class);
    //声明一个logBase函数调用
    public Object logBase(ProceedingJoinPoint joinPoint ,String name)throws  Throwable{
        long time=System.currentTimeMillis();//记录开始时间
        Object object=joinPoint.proceed();//执行方法
        time=System.currentTimeMillis()-time;//计算执行时间
        //joinPoint.getSignature().getName()获取类中的方法名。
        logger.info(name+" "+joinPoint.getSignature().getName()+" run time: "+time);
        return object;
    }

    //统计controller处理时间
    @Around(value = "execution(* com.jns.controller.StudentController.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint)throws Throwable{
        return logBase(joinPoint,"controller");
    }

    //统计DB访问时间
    @Around(value = "execution(* com.jns.service.impl.StudentServiceImpl.*(..))")
    public Object logServiceImpl(ProceedingJoinPoint joinPoint)throws Throwable{
        return logBase(joinPoint,"database");
    }
}
