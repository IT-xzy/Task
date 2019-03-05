package com.jnshu.clroom.loggerAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    //private  static final logger logger = LogManager.getLogger(LoggingAspect);
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    // 定义环绕通知的切点
    @Around(value = "execution(* com.jnshu.clroom.controller.*.*(..)) || execution(* com.jnshu.clroom.service.*.*(..)) ")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        obj = joinPoint.proceed(args);
        // 获取执行的方法名
        long time = System.currentTimeMillis() - startTime;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        // 打印耗时的信息
        this.printTime(methodName, time);
        return obj;
    }

    @Around( value = "execution(* com.jnshu.clroom.controller.*.*(..)) || execution(* com.jnshu.clroom.service.*.*(..)) ")
    public Object logException(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {

            Object[] args = joinPoint.getArgs();
            obj = joinPoint.proceed(args);
            return obj;
        } catch (Throwable e){
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
            this.printException(methodName,e.toString());
        }
        return obj;
    }

    private void printTime(String methodName, long time) {
        logger.info("方法名:" + methodName + "; 耗时:" + time + "ms");
    }

    private void printException(String methodName, String exceptionName){
        logger.info("方法名:" + methodName + "; 异常名称是:" + exceptionName);
    }
}
