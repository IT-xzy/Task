package com.jnshu.tools;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
class DBAop {
    private static Logger logger = Logger.getLogger(DBAop.class);
    private static long time1 = 0;

    @Before("execution(* com.jnshu.dao.UserMapper.*(..))")
    public void beginTransaction() {
        time1 = System.currentTimeMillis();
//        System.out.println("[前置通知] DB 开启事务.."+time1);
    }

    @After("execution(* com.jnshu.dao.UserMapper.*(..))")
    public void commit(JoinPoint joinPoint) {
        long time2 = System.currentTimeMillis();
//        System.out.println("[后置通知] DB提交事务.."+time2);
//        System.out.println(time2-time1+"ms ");
//        System.out.println(joinPoint.getSignature().getName());
        String DB = "数据库操作总耗时： "+(time2-time1)+"ms "+"操作方法为："+joinPoint.getSignature().getName()+" Resin";
        logger.info(DB);
//        System.out.println(DB);
    }

   /* @AfterReturning("execution(* com.jnshu.dao.UserMapper.*(..))")
    public void afterReturing() {
        long time2 = System.currentTimeMillis();
        System.out.print("[DB返回后通知");
        System.out.println(time2-time1+"ms ]");
    }*/

    @AfterThrowing("execution(* com.jnshu.dao.UserMapper.*(..))")
    public void afterThrowing() {
        System.out.println("[DB异常通知]");
    }

    /**
     * Controller AOP
     */
        @Before("execution(* com.jnshu.controller.UserController.*(..))")
        public void beginController() {
            time1 = System.currentTimeMillis();
//            System.out.println("[前置通知] CT开启事务.."+time1);
        }

        @After("execution(* com.jnshu.controller.UserController.*(..))")
        public void afterController(JoinPoint joinPoint) {
            long time2 = System.currentTimeMillis();
            System.out.println("[后置通知] CT提交事务.."+time2);
//            System.out.println(time2-time1+"ms ");
//            System.out.println(joinPoint.getSignature().getName());
            String Contr = "Controller操作总耗时： "+(time2-time1)+"ms "+"操作方法为："+joinPoint.getSignature().getName()+" Resin";
//            System.out.println(Contr);
            logger.info(Contr);
        }
    }
