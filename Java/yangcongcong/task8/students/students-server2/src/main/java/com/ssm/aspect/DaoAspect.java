package com.ssm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {
    private static final Logger logger = LoggerFactory.getLogger(DaoAspect.class);

    private static final long TIME = 50;

    public static final String POINTCUT = "execution(* com.ssm.dao.*.*(..))";

    @Around(POINTCUT)
    public Object timeAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object object=null;
        Object[] args = proceedingJoinPoint.getArgs();
        long startTime=System.currentTimeMillis();
        try {
            object = proceedingJoinPoint.proceed(args);
        }catch(Throwable e){
            logger.error("统计某方法执行耗时环绕通知出错"+e);
        }
        long endTime = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName=methodSignature.getDeclaringTypeName()+"."+methodSignature.getName();

        this.printExecTime(methodName,startTime,endTime);

        return object;
    }

    /**
     * 打印方法执行耗时的信息
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
//        if (diffTime>TIME) {
//            logger.info("-----------" + methodName + " 方法执行耗时:" + diffTime + " ms");
//        }
        logger.info("-----------" + methodName + "方法执行耗时 " + diffTime + " ms");
    }
}
