package wyq.springmvc.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodTimeMonitor{
//    private long t;
    protected final Log logger = LogFactory.getLog(MethodTimeMonitor.class);

    public Object logBase(ProceedingJoinPoint joinPoint,String name) throws Throwable{
        long t = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        t = System.currentTimeMillis() - t;
        logger.info(name+" "+joinPoint.getSignature().getName()+" runtime "+t);
        return obj;
    }

    @Around("execution(* wyq.springmvc.controllers.*.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint)throws Throwable{
        return logBase(joinPoint,"controller");
    }

    @Around("execution(* wyq.springmvc.service.impl.*.*(..))")
    public Object logServiceImpl(ProceedingJoinPoint joinPoint)throws Throwable{
        return logBase(joinPoint,"service");
    }

}
