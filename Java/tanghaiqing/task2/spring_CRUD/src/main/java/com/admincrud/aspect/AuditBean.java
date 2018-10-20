package com.admincrud.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
    @Around("within(com.admincrud.service..*)")
    public Object audit(ProceedingJoinPoint point) {
        Object obj = null;
        try {
            long start = System.currentTimeMillis();
            obj = point.proceed();
            long end = System.currentTimeMillis();
            String str =point.getSignature().toString();
            System.out.println(str+"耗时："+(end-start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
