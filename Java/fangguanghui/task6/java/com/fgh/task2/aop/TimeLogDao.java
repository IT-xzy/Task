package com.fgh.task2.aop;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class TimeLogDao {
    private static Logger logger = LogManager.getLogger(TimeLogDao.class.getName());

    @Pointcut(value = "execution(* com.fgh.task2.dao.StuDao.*(..))")
    private void myMethod(){
    }


    @Around(value = "myMethod()")
    public Object processlog(ProceedingJoinPoint point)throws Throwable{
        long startTime=System.currentTimeMillis();
        Object obj = null;
        //获取传入目标方法的参数
        Object[] args=point.getArgs();

        try{
            obj=point.proceed(args);
        }catch (Throwable ex){
            logger.error("统计某方法执行耗时环绕通知出错", ex);
        }

        long endTime=System.currentTimeMillis();

        String className=point.getSignature().getDeclaringTypeName();
        String methodName=point.getSignature().getName();
        String methodPath=className+"."+methodName;

        //
        this.printExecTime(methodPath,startTime,endTime);
        return obj;
    }

    private void printExecTime(String methodPath,long startTime,long endTime){
        long difftime= endTime-startTime;
        logger.debug("执行方法: "+methodPath+" 执行时间: "+difftime+" ms");
    }


}
