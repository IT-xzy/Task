    package com.iceneet.aop;

    import org.apache.log4j.Logger;
    import org.aspectj.lang.JoinPoint;
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Pointcut;
    import org.springframework.stereotype.Component;


    @Component
    @Aspect
    public class DbAspect {
        Logger logger = Logger.getLogger(DbAspect.class);
        //private static Log logger = LogFactory.getLog(AopController.class);

        @Pointcut("execution(* com.iceneet.service.Signupservice1.*(..))")
            private void DbPointcut(){
        }

        @Around("DbPointcut()")
        private Object DbSpendTime(ProceedingJoinPoint joinPoint){
            Object obj = null;
            Object[] args = joinPoint.getArgs();
            long startTime = System.currentTimeMillis();
            try {
                obj =joinPoint.proceed(args);
            }catch (Throwable e){
                logger.error(e);
            }
            long endTime = System.currentTimeMillis();
            String methodName = joinPoint.getSignature().getDeclaringTypeName()
                    +"."+joinPoint.getSignature().getName();
            this.Log4Time(methodName,startTime,endTime);
            return obj;
        }
        private void Log4Time(String methodName,long startTime,long endTime){
            long Timespead = endTime - startTime;
            logger.info(methodName+" DB 花费时间 "+Timespead+" ms");
        }

    }
