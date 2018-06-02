package com.restful.aspect;

import com.restful.model.MonitorAspectModel;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MonitorAspect {

    private static Logger logger = Logger.getLogger(MonitorAspect.class);

    private MonitorAspectModel mam = new MonitorAspectModel();

    private Date date;


    @Test
    public void trest(){
        logger.info("测试类");
    }

//    @Pointcut(value = "execution(* com.restful.controller.*Controller*.*(..))")
//    private void controllerointcut(){}

//    @Around(value = "controllerointcut()")
    @Around(value = "execution(* com.restful.controller.RestController.*(..))")
    public Object controllerRunTime(ProceedingJoinPoint joinPoint) throws Throwable {

        mam.setClassName(joinPoint.getClass().getName());

        mam.setMethodName(joinPoint.getSignature().getName());

        mam.setStartTime(System.currentTimeMillis());

        mam.setStartDate(new Date());

        logger.info("\n==Controller切面开始计时==\n");

//        代理类 执行目标
        Object object = joinPoint.proceed();

        mam.setEndTime(System.currentTimeMillis());

        mam.setRunTime(mam.getStartTime()-mam.getEndTime());

        logger.info("\n info 日志记录： Controller开始时间：" + mam.getStartDate() + "| 响应时间：" + mam.getRunTime() + "ms" + " | 执行类：" + mam.getClassName() + " | 执行方法：" + mam.getMethodName() + "\n");
        logger.debug("\n debug 日志记录： Controller开始时间：" + mam.getStartDate() + "| 响应时间：" + mam.getRunTime() + "ms" + " | 执行类：" + mam.getClassName() + " | 执行方法：" + mam.getMethodName() + "\n");

        return object;
    }


}
