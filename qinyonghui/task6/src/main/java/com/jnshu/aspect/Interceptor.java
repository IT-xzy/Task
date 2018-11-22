package com.jnshu.aspect;

        import org.apache.log4j.Logger;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.springframework.stereotype.Component;

@Aspect
@Component
public class Interceptor {
    static Logger logger = Logger.getLogger(Interceptor.class);

    //    切入点表达式，可声明返回值、包、类、方法、参数
    @Pointcut("execution(* com.jnshu.controller.*.*(..))||execution(* com.jnshu.service.*.*(..))" +
            "||execution(* com.jnshu.mapper.*.*(..))")
    public void declareJointPointExpression() {
    }

    @Around("declareJointPointExpression()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
//        joinPoint.getArgs()代表取得joinPoint（即目标方法）的入参
//        执行目标方法
        Object object =
                joinPoint.proceed
                        (joinPoint.getArgs());//执行被通知的方法
        long cost = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature() + "——方法用时——" + cost + "毫秒");
        return object;
    }
}
