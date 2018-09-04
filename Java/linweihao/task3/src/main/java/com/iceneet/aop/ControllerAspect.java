package com.iceneet.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//和sping整合的时候必须要这个注解，否则sping容器解析不到该切面导致切面不能工作
@Aspect
@Component
public class ControllerAspect {
    //private static Log logger = LogFactory.getLog(AopController.class);
    private Logger logger = Logger.getLogger(ControllerAspect.class);
    //切点
    @Pointcut("execution(* com.iceneet.web.SignupController.*(..))")
    private void myPointcut(){

    }

    //增强处理
    @Around("myPointcut()")
    public Object ControllerTime(ProceedingJoinPoint joinpoint){
        Object obj = null;
        Object[] args = joinpoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj =joinpoint.proceed(args);
        }catch (Throwable e){
            logger.error(e);
        }
        long endTime = System.currentTimeMillis();
        String methodName = joinpoint.getSignature().getDeclaringTypeName()
                +"."+joinpoint.getSignature().getName();
        this.Log4Time(methodName,startTime,endTime);
        return obj;
    }

    private void Log4Time(String methodName,long startTime,long endTime){
        long Timespead = endTime - startTime;
        logger.info(methodName+" Controller 花费时间 "+Timespead+" ms");
    }
}
