package jnshu.Aop;

import jnshu.controller.BannerController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    private static final Logger logger = Logger.getLogger(LogAop.class);
    private long startTime;

    @Pointcut("execution(* jnshu.controller.*.*(..))")
    public void pointcut() {
    }//声明一个切入点

    // 声明该方法是一个前置通知：在目标方法开始之前执行
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("-------前置通知-----------");
        this.startTime = System.currentTimeMillis();
    }

    // 声明该方法是一个后置通知：在目标方法开始之后执行
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        logger.warn("-------最终通知---------");
        long endTime = System.currentTimeMillis();
        logger.warn("controller层方法执行了" + (endTime - this.startTime) + "ms");

    }


    @Pointcut("execution(* jnshu.service.Impl.*.*(..))")
    public void pointcut1() {
    }//声明一个切入点

    // 声明该方法是一个前置通知：在目标方法开始之前执行
    @Before("pointcut1()")
    public void before1(JoinPoint joinPoint) {
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("-------前置通知-----------");
        this.startTime = System.currentTimeMillis();
    }

    // 声明该方法是一个后置通知：在目标方法开始之后执行
    @After("pointcut1()")
    public void after1(JoinPoint joinPoint) {
        logger.warn("-------最终通知---------");
        long endTime = System.currentTimeMillis();
        logger.warn("service层方法执行了" + (endTime - this.startTime) + "ms");

    }


}
