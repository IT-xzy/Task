package com.xiaobo.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.constant.Global;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect  //表示这是一个切面类，里面的方法都是像打印日志等围绕业务方法的方法
public class TimeAndParamAspect {
    private static Logger log = Logger.getLogger(TimeAndParamAspect.class);
    @Pointcut("execution(* com.xiaobo.demo.controller.*.*(..)) || execution(* com.xiaobo.demo.service.*.*(..))")
    public void executeTimePointcut(){}
    @Pointcut("execution(* com.xiaobo.demo.controller..*.*(..))")
    public void executeParamPointcut(){}
    // 记录时间
//    @Around("execution(* com.xiaobo.demo.service.*.*(..))")
//    @Around(value = "execution(* com.xiaobo.demo.controller.*.*(..)) || execution(* com.xiaobo.demo.service.*.*(..))")
    @Around("executeTimePointcut()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try{
            obj = joinPoint.proceed(args);
        }catch(Throwable e){
            log.error("统计某方法执行环绕时出错",e);
        }
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName()+","+signature.getName();
        this.printExecuteTime(methodName,startTime,endTime);
        return obj;
    }
    private void printExecuteTime(String methodName,long startTime,long endTime){
        long executeTime = endTime - startTime;
        log.warn(methodName+"方法执行耗时："+executeTime+"ms");
        if(executeTime> Global.LOG_WARN_EXECUTE_TIME){
            log.error(methodName+"方法执行耗时"+executeTime+"ms");
        }
    }
    // 记录参数
    @Around("executeParamPointcut()")
    public Object logParam(ProceedingJoinPoint joinPoint) throws Throwable{
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            if(arg instanceof  JSONObject){
                log.warn("传入参数"+JSONObject.toJSON(arg)+"");
            }
        }
        try{
            obj = joinPoint.proceed(args);
//            log.warn("返回参数");
//            log.warn(JSONObject.toJSON(obj));
        }catch(Throwable e){
            log.error("统计某方法执行环绕时出错",e);
        }

        return obj;
    }
}
