package com.lyh.aop;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advices {
    private static final Log logger = LogFactory.getLog(Advices.class);
    private long startTime;
    @Pointcut("execution(* com.lyh.service.StudentService.*(..))")
    public void pointcut(){}//声明一个切入点

    // 声明该方法是一个前置通知：在目标方法开始之前执行
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("-------前置通知-----------");
        this.startTime = System.currentTimeMillis();
    }
    // 声明该方法是一个后置通知：在目标方法开始之后执行
    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        logger.warn("-------最终通知---------");
        long endTime = System.currentTimeMillis();
        logger.warn("方法执行了"+(endTime-this.startTime)+"ms");

    }

    // 声明该方法是一个环绕通知
 @Around(value = "execution(* com.lyh.controller.StudentController.*(..)) || execution(* com.lyh.service.StudentService.*(..)) ")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        logger.warn(proceedingJoinPoint.getSignature().getName());
        logger.warn("----------环绕前置-----------");
        Object result = proceedingJoinPoint.proceed();
        logger.warn("--------环绕后置-----------");
        return result;
 }
    // 声明该方法是一个返回结果通知
 @AfterReturning(value = "execution(* com.lyh.service.StudentService.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("结果是"+result);
        logger.warn("-------返回结果--------");
 }
    // 声明该方法是一个异常通知
 @AfterThrowing(value = "execution(* com.lyh.service.StudentService.*(..))",throwing = "exp")
    public void afterThrowing(JoinPoint joinPoint,Exception exp){
        logger.warn(joinPoint.getSignature().getName());
        logger.warn("异常消息："+exp.getMessage());
        logger.warn("---------异常通知-------------");
 }
}
