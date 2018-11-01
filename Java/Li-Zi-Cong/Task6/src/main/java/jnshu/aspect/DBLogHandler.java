package jnshu.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;


//@Aspect
public class DBLogHandler {

    Logger logger = Logger.getLogger(DBLogHandler.class);
    long time =0;
    public void beforeDAO(){
        time=System.currentTimeMillis();
    }
    public void afterDAO(JoinPoint joinPoint){
        logger.error("    "+joinPoint.getSignature().getName()+": "+(System.currentTimeMillis()-time));
    }
}
