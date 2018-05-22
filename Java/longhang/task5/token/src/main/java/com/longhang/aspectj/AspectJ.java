package com.longhang.aspectj;
import org.slf4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
    public class AspectJ {
        private final Logger logger= (Logger) LoggerFactory.getLogger(AspectJ.class);
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


