package com.myitschool.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//import java.util.logging.Logger;
@Aspect
@Component
public class MemcachedAspect {

    @Autowired
    private MemcachedClient memcachedClient;

    private final Logger logger = Logger.getLogger(MemcachedAspect.class);

    private static boolean flag = false;

    @Pointcut("execution(* com.myitschool.service.StudentService.*(..)) && !execution(* com.myitschool.service.StudentService.selectStudent(..))")
    public void studentService() {
    }

    //    解决线程安全问题，线程绑定ThreadLocal
    @Around("studentService()")
    public Object studentServiceAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
//        Method[] methods = pjp.getTarget().getClass().getDeclaredMethods();
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
//        for(Method m : methods){
//            if(m.getName().equals(method.getName())){
//                System.out.println(m.getName());
//            }
//        }
        if ("allStudent" != method.getName()) {
            result = pjp.proceed();
            flag = true;
        } else {
            try {
                if(flag || null == memcachedClient.get("allStudent")) {
                    memcachedClient.set("allStudent", 0, pjp.proceed());
                    logger.info("update");
                }
                result = memcachedClient.get("allStudent");
                logger.info("search all from memcached");
            } catch (Exception e) {
                result = pjp.proceed();
                logger.info("search all from mysql");
            }
            flag =false;
        }
        return result;
    }
}
