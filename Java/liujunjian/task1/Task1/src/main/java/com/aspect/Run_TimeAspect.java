package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Run_TimeAspect {
    public void run_time(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        System.out.println("操作用时：" + (endTime - startTime)+"ms");
    }
}
