package com.Logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component(value = "logger")
@Aspect
public class LogInterceptor {

    private final Logger logger=Logger.getLogger(LogInterceptor.class);
    private long controllerStartTime,controllerEndTime;


    //获得控制层方法开始时的时间戳
    @Pointcut("execution(* com.controller.UserController.*(..))")
    public void controllerAdd(){}
    @Before("controllerAdd()")
    public void controllerAddBefore(){
        controllerStartTime=System.currentTimeMillis();
    }

    //获得控制层方法结束时的时间戳，并通过减去控制层方法开始的时间戳获得方法的执行时间
    @After("controllerAdd()")
    public void controllerAddAfter(JoinPoint joinPoint){
        controllerEndTime=System.currentTimeMillis();
        //控制器的时间里包括了db的时间
        logger.info("Controller:"+joinPoint.getSignature().getName()+":"+(controllerEndTime-controllerStartTime)+"ms");
    }
}
