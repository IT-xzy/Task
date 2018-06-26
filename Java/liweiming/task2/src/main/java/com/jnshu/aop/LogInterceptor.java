package com.jnshu.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogInterceptor{

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    /**
     * @Description: 定义切入点
     * @Explain: com.jnshu.controller.*Controller*.* 切入所有controller包下类名包含Controller的类的所有方法
     */
    @Pointcut(value = "execution(* com.jnshu.ssm.controller.*Controller*.*(..))")
    private void handlerTimer(){}

    /**
     * @Description: 环绕通知
     * @Explain: handlerTimer() 代表使用 handlerTimer()的切点
     */
    @Around(value = "handlerTimer()")
    public Object controllerLogTimer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 获取目标类名
        String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
        // 获取目标方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        Date LogTime = new Date();

        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        // 执行代理类
        Object result = proceedingJoinPoint.proceed();
        long time = System.currentTimeMillis() -start;

        logger.info( "性能日志 Controller类 " + "响应时间: " + time + "ms " + "执行信息: 执行 " + clazzName+" 中方法 "+methodName + " 执行时间: " + LogTime);
        return result;
    }
}
