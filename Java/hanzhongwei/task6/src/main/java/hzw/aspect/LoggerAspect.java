package hzw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Around(value = "execution(* hzw.service.StudentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long t1 = System.currentTimeMillis();
        String time1 = simpleDateFormat.format(new Date());
        logger.info("开始统计"+joinPoint.getSignature().getName());
        logger.info("开始时间"+time1);
        Object object = joinPoint.proceed();
        long t2 = System.currentTimeMillis();
        String time2 = simpleDateFormat.format(new Date());
        logger.info("结束统计"+joinPoint.getSignature().getName());
        logger.info("结束时间"+time2);
        logger.info("过程耗时："+(t2-t1)+"毫秒");
        return object;
    }

    @Around(value = "execution(* hzw.service.ServiceManage.*(..))")
    public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long t1 = System.currentTimeMillis();
        String time1 = simpleDateFormat.format(new Date());
        logger.info("开始官网统计"+joinPoint.getSignature().getName());
        logger.info("开始官网时间"+time1);
        Object object = joinPoint.proceed();
        long t2 = System.currentTimeMillis();
        String time2 = simpleDateFormat.format(new Date());
        logger.info("结束官网统计"+joinPoint.getSignature().getName());
        logger.info("结束官网时间"+time2);
        logger.info("过程官网耗时："+(t2-t1)+"毫秒");
        return object;
    }
}
