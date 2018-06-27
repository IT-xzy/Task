package com.task1.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.text.SimpleDateFormat;

@Aspect
public class TimeInterceptor {
    long start;
    long end;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(* com.task1.service.UserMapperService.*(..))")
    private void anyMethod() {

    }

    @Around("anyMethod()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
Object result=null;
        long start = System.currentTimeMillis();
        try{
//        前置通知
        System.out.println("方法开始时间" + simpleDateFormat.format(start));
        System.out.println("目标方法名:"+proceedingJoinPoint.getSignature().getName());
//        打印切面对应执行方法
        System.out.println(proceedingJoinPoint.toString());
//        执行目标方法
      result= proceedingJoinPoint.proceed();
        //返回通知
        System.out.println("The method: " +"返回通知");
    }catch(Throwable e)
    {
        //异常通知
        System.out.println("The method: "  + "异常通知： " + e.getMessage());
    }
    //      后置通知
        long end = System.currentTimeMillis();
        System.out.println("方法结束时间：" + simpleDateFormat.format(start));
        return result;
    }

//    @Before("anyMethod()")
//    public void doBefore(JoinPoint joinPoint) {
//      start = System.currentTimeMillis();
//
//        System.out.println("this is before time:" + simpleDateFormat.format(start));
//    }
//
//    @After("anyMethod()")
//    public void doAfter() {
//       end = System.currentTimeMillis();
//
//        System.out.println("this is after time" +simpleDateFormat.format(end));
//
//
//    }

}
