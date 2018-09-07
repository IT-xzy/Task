package com.task2.acpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogAspect.class);
    public static final String POINT = "execution(* com.task2.service.impl.*.*(..))";
    public static final String POINT1 = "execution(* com.task2.controller.*.*(..))";
    //定义DB连接时间的环绕通知，切面POINT
    @Around(POINT)
    public Object printDBTime(ProceedingJoinPoint joinPoint){
        return timeAround(joinPoint);
    }
    //定义controller处理时间的环绕通知，切面为POINT1
    @Around(POINT1)
    public Object printConTime(ProceedingJoinPoint joinPoint){
        return timeAround(joinPoint);
    }
    //定义方法执行耗时的方法
    public Object timeAround(ProceedingJoinPoint joinPoint){
        //定义返回对象，得到方法需要的参数
        Object object = null;
        Object[]args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try{
            object = joinPoint.proceed(args);
        }catch (Throwable e){
            logger.error("统计某方法执行时环绕通知出错",e);
        }
        //获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName()+"."+signature.getName();
        //打印耗时的信息
        this.printExecTime(methodName,startTime,endTime);
        return object;
    }
    private void printExecTime(String methodName,long startTime,long endTime){
        long diffTime = endTime - startTime;
        logger.info("--------------------" + methodName + " 方法执行耗时：" + diffTime + " ms");

    }
}
