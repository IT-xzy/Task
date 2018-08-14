package util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
 public  class  TimeAop{

    private Logger logger = Logger.getLogger("TimeAop.class");
     Long a;
     public Long before(){
         a =System.currentTimeMillis();
         return a;
     }
     public void after(){
         Long b =System.currentTimeMillis();
         Long c=b-a;
         logger.info("执行方法耗时："+c);
     }
 }
