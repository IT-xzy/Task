package com.ptteng;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Component//加入IOC容器
@Aspect//表示这是一个切面类
public class LogAspect {
    protected Logger log = Logger.getLogger(LogAspect.class);
    //value中为切入点表达式
    @Before(value = "execution(public * com.ptteng.*.*.*(..))")//前置通知
    public void showBeginLog() {
        System.out.println("AOP日志开始");
    }

    @After(value = "execution(public * com.ptteng.*.*.*(..))")//后置通知
    public void showReturnLog() {
        System.out.println("AOP方法结束");
    }

    @AfterThrowing(value = "execution(public * com.ptteng.*.*.*(..))")//异常通知
    public void showExceptionLog() {
        System.out.println("AOP方法异常");
    }

    @AfterReturning(value = "execution(public * com.ptteng.*.*.*(..))")//返回通知
    public void showAfterLog() {
        System.out.println("AOP方法最终返回");
    }

    @Around(value = "execution(public * com.ptteng.controller.*.*(..))")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {

        long t1 = System.currentTimeMillis();
        //调用方法的参数
        Object[] args = pjp.getArgs();
        //调用的方法名
        String method = pjp.getSignature().getName();
        //获取目标对象
        Object trage = pjp.getTarget();
        //执行完方法的返回值
        //调用proceed（）方法，就会出发切入点方法执行
        Object result = pjp.proceed();
        Long T2 = System.currentTimeMillis();
        log.info("响应时间=========================================================================" +
                "=============================" + (T2 - t1));
        //打印方法名字
        log.info(method);
        return result;
    }

    @Around(value = "execution(public * com.ptteng.dao.StudentDao.*(..))")
    public Object time1(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        //调用方法的参数
        Object[] args = pjp.getArgs();
        //调用的方法名
        String method = pjp.getSignature().getName();
        //获取目标对象
        Object trage = pjp.getTarget();
        //执行完方法的返回值
        //调用proceed（）方法，就会出发切入点方法执行
        Object result = pjp.proceed();
        Long T2 = System.currentTimeMillis();
        log.info("访问DB时间=========================================================================" +
                "=============================" + (T2 - t1));
        //打印方法名字
        log.info(method);
        return result;
    }
}
