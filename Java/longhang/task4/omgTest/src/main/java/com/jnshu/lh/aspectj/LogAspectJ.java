package com.jnshu.lh.aspectj;


import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogAspectJ {
    private final Logger logger= LoggerFactory.getLogger(LogAspectJ.class);
    public void before(){}
    public void after(){}
    public Object around(ProceedingJoinPoint pjd){
        Long start =System.currentTimeMillis();
        Object result=null;
        String method= pjd.getSignature().getName();
        try {
            logger.info("the method "+"\""+method+"\""+" begins ");
            result=pjd.proceed();
            logger.info("the method "+"\""+method+"\""+"result "+ result);
        } catch (Throwable e) {
            logger.info("the mehtod "+"\""+method+"\""+" occurs exception:" + e );
            throw new RuntimeException(e);
        }
             logger.info("the method "+"\""+method+"\""+"end");
        Long end =System.currentTimeMillis();
        logger.info("the controller run time : "+ (end-start));
        return result;
    }
}
