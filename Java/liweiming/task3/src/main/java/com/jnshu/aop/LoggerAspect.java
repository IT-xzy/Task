package com.jnshu.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class LoggerAspect {

    private static Log logger = LogFactory.getLog(LoggerAspect.class);

    /*
    * execution 常用切入点指示符，匹配方法执行的连接点
    * */
    @Around(value = "execution(* com.jnshu.ssm.service.UserService.*(..))")

    public Object log(ProceedingJoinPoint joinPoint)throws Throwable{
//         定义返回对象
        Object object = null;
        long startTime = System.currentTimeMillis();
        try {
            object = joinPoint.proceed();
        }catch (Throwable e){
            logger.error("统计某方法执行耗时环绕通知出错!!",e);
        }
//        获得执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." +signature.getName();
        Method methodname = signature.getMethod();
//        打印耗时的信息
        this.printExecTime(methodName,startTime,endTime,methodname);
        return object;
    }
    private void printExecTime(String methodName, long startTime, long endTime,Method methodname) {
        long diffTime = endTime - startTime;
        logger.info("性能日志 UserService类" + " 响应时间：" + diffTime + "ms" + " 执行方法：" + methodname );
    }

}
