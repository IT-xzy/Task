package task2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

//@Aspect
@Component
public class LoggerTime {
//    @Around("execution(* task2.service.UserServiceImpl.login(..)")
    public Object logCon(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = Logger.getLogger(String.valueOf(LoggerTime.class));
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("此次访问Controller层用时：" + (endTime - startTime) + "毫秒");
        return object;
    }

    //    @Around("execution(* task2.service.UserServiceImpl.login(..)")
    public Object logDb(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger=Logger.getLogger(String.valueOf(LoggerTime.class));
        long startTime=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("此次访问数据库用时："+(endTime-startTime)+"毫秒");
        return object;
    }
}
