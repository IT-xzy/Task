package com.artist.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
    @Around("within(com.artist.service..*)")
    public Object audit(ProceedingJoinPoint point) throws Throwable {
        Object obj = null;
        Long startTime = System.currentTimeMillis();
        obj = point.proceed();
        Long endTime = System.currentTimeMillis();
        String str = point.getSignature().toString();
        System.out.println(str + "耗时:" + (endTime - startTime));
        return obj;
    }
}
