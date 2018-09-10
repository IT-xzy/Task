package task8services.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
public class TimeInterceptor {
    private static Log logger = LogFactory.getLog(TimeInterceptor.class);

    @Around("execution(* task8services.mapper.*.*(..))")
    public Object aroundDao(ProceedingJoinPoint proceedingJoinPoint){
        TimeInterceptorUtil timeInterceptorUtil2 = new TimeInterceptorUtil();
        Object obj = timeInterceptorUtil2.timeAround(proceedingJoinPoint);
        return obj;
    }

}
