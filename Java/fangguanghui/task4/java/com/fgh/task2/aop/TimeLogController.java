package com.fgh.task2.aop;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.text.SimpleDateFormat;

@Aspect
public class TimeLogController {

    private static Logger logger = LogManager.getLogger(TimeLogController.class.getName());

        @Pointcut(value = "execution(* com.fgh.task2.controller.*.*(..))")
        private void controllerMethod(){
        }

        @Around("controllerMethod()")
        public Object serviceTimer(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
            String methodName=proceedingJoinPoint.getSignature().getName();
            String className=proceedingJoinPoint.getSignature().getDeclaringTypeName();
            long startTime=System.currentTimeMillis();



            Object object =null;
            Object[] args=proceedingJoinPoint.getArgs();

            try{
                object =proceedingJoinPoint.proceed(args);
            }catch (Throwable e){
                logger.error("统计方法执行耗时环绕通知出错");
            }

            long endTime=System.currentTimeMillis();
            String methodPath=className+"."+methodName;

            this.printExecTime(methodPath,startTime,endTime);

            return  object;
        }

        public void printExecTime(String methodPath,long startTime,long endTime){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long difftime= endTime-startTime;
            logger.debug("执行方法: "+methodPath+" 执行时间: "+difftime+" ms "
                        + "执行日期: "+sdf.format(startTime));
        }

}
