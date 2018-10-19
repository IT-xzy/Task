package com.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 通知类,横切逻辑
 * */
public class Advices {
    /*前置增强*/
    public void before(JoinPoint jp1) {
        System.out.println("-------前置通知-------");
        System.out.println(jp1.getSignature().getName());
    }

    public void after(JoinPoint jp){
        System.out.println("-------最终通知-------");
    }

    /*环绕增强*/
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object obj;
        System.out.println("方法前环绕");
        obj=pjp.proceed();
        System.out.println("方法后环绕");
        return obj;
    }
}
