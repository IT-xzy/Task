package jnshu.model.aopTool;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * API接口性能分析
 */
@Aspect
public class TimerAspect {
    private static Logger logger = Logger.getLogger (TimerAspect.class);//引入日志配置
    /**
     * 定义切点函数
     */
    @Pointcut("execution(* jnshu.controller.*.*(..))||execution(* jnshu.service.*.*(..))")
    void timer() {
    }

    @Around("timer()")
    public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable {

//        MonitorTime monitorTime=new MonitorTime();
        //获取目标类名称
        String clazzName = thisJoinPoint.getTarget().getClass().getName();
        //获取目标类方法名称
        String methodName = thisJoinPoint.getSignature().getName();

        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = thisJoinPoint.proceed();
        long time = System.currentTimeMillis() - start;
//        System.out.println (result.toString ());
        logger.warn ("执行"+clazzName+"中的方法"+methodName+"消耗时间为："+time);
        return result;
    }
}
