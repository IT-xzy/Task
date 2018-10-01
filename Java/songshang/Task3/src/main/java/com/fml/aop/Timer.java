package com.fml.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
    private static final Logger logger = Logger.getLogger(Timer.class);


    @Pointcut(value = "execution(* com.fml.controller.StudentController.*(..))")
    public void controller() { }

    @Pointcut(value = "execution(* com.fml.mapper.StudentMapper.*(..))")
    public void dao() { }

    @Pointcut(value = "execution(* com.fml.service.impl.StudentServiceImpl.*(..))")
    public void service() { }

    //@Around("execution(* com.fml.mapper.StudentMapper.*(..))")
    @Around(value = "dao() || service() || controller()")
    public Object printTime(ProceedingJoinPoint joinPoint){
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long start = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            logger.error("统计某方法执行耗时环绕通知出错", throwable);
        }
        long end = System.currentTimeMillis();
        // 获取执行的方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        logger.info(methodName + " 处理时间为：" + (end - start) + "毫秒");
        return obj;
    }
}
