 package com.aop;

 import com.controller.UserController;
 import org.apache.log4j.Logger;
 import org.aspectj.lang.annotation.After;
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Before;
 import org.aspectj.lang.annotation.Pointcut;
 import org.springframework.stereotype.Component;

 @Aspect
 @Component
 class TransactionAop
 {
   private Logger logger = Logger.getLogger(UserController.class);
   long time1 = 0L;

   public TransactionAop() {
     System.out.println("\n");
   }

   @Pointcut("execution(* com.controller.UserController.*(..))")
   public void pointController() {
   }

   @Pointcut("execution(* com.dao.UserMapper.*(..))")
   public void pointDB() {
   }

   @Before("pointController()")
   public void beginTransaction() {
     this.time1 = System.currentTimeMillis();
   }

   @After("pointController()")
   public void commit() {
     long time2 = System.currentTimeMillis();
     this.logger.info("Controller耗时： " + (time2 - this.time1) + " ms");
   }

   @Before("pointDB()")
   public void before() {
     this.time1 = System.currentTimeMillis();
   }

   @After("pointDB()")
   public void after() {
     long time2 = System.currentTimeMillis();
     this.logger.info("DB耗时： " + (time2 - this.time1) + " ms");
   }
 }
