package com.jnshu.aop;

import com.jnshu.model.MonitorTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @program: taskTwo
 * @description: DB 接口性能分析
 * @author: Mr.xweiba
 * @create: 2018-05-07 02:14
 * @Explain: 此切面的配置文件只能放在spring配置中
 **/



@Aspect
public class TimeAsperctUserService {

    private static Logger logger = LoggerFactory.getLogger(TimeAsperctUserService.class);

    // db接口测试
    @Pointcut("execution(* com.jnshu.service.UserService.*(..))")
    private void userServiceTimer(){}


    /**
    * @Description:  UserService 接口环绕通知
    * @Param: dbLogTimer
    * @return: java.lang.Object
    * @Author: Mr.Wang
    * @Date: 2018/5/7
    * @Explain:
    */
    @Around(value = "userServiceTimer()")
    public Object dbLogTimer (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 创建性能监控信息类
        MonitorTime monitorTime = new MonitorTime();
        // 获取目标类名
        String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
        // 获取目标方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        // 记录目标类名
        monitorTime.setClassName(clazzName);
        // 记录目标方法名
        monitorTime.setMethodName(methodName);
        // 记录开始时间
        monitorTime.setLogTime(new Date());

        // 计时并调用目标函数
        logger.debug("=== UserService接口切面开始 ===");
        // 毫秒为单位的当前时间
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long time = System.currentTimeMillis() -start;
        monitorTime.setComsumeTime(time);
        logger.info( "性能日志 DB类 " + "响应时间: " + monitorTime.getComsumeTime() + "ms " + "执行信息: 执行 " + monitorTime.getClassName()+" 中方法 "+monitorTime.getMethodName() + " 执行时间: " + monitorTime.getLogTime() );
        return result;
    }
}
