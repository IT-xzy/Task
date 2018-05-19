package com.fml.aop;

import com.fml.cache.StudentCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimerAspectHandel {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerAspectHandel.class);

    @Autowired
    StudentCache studentCache;

    @Pointcut(value = "execution(* com.fml.controller.HomeController.*(..)) || execution(* com.fml.controller.VocationController.*(..)))")
    public void controller(){}

    @Pointcut(value = "execution(* com.fml.service.impl.StudentServiceImpl.*(..)) || execution(* com.fml.service.impl.VocationServiceImpl.*(..))")
    public void service(){}

    @Pointcut(value = "execution(* com.fml.mapper.StudentMapper.*(..)) || execution(* com.fml.mapper.VocationMapper.*(..)))")
    public void mapper(){}

    /**
     * 统计各个方法处理的时间。日志太多可以先关了
     * @param joinPoint
     * @return
     */
    /*
    @Around(value = "controller() || service() || mapper()")
    public Object calculateTime(ProceedingJoinPoint joinPoint){
        Object object = null;
        Object[] args = joinPoint.getArgs();
        long start = System.currentTimeMillis();

        try {
            object = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            LOGGER.error("统计方法执行耗时出错",throwable);
        }

        long end = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        LOGGER.info(methodName + " 处理时间为：" + (end - start) + "毫秒");
        return object;
    }
    */

    /**
     * 学员数据被删除或者更新，缓存中的数据就有问题了，得删除
     */
    @After(value = "execution(* com.fml.mapper.StudentMapper.delete*(..)) || execution(* com.fml.mapper.StudentMapper.update(..))")
    public void delMemcache() {
        studentCache.delete("studentList");
        studentCache.delete("superStudentList");
        studentCache.delete("totalCount");
        studentCache.delete("workCount");
        LOGGER.info("学员数据有变化，学员缓存已清除");
    }

    /*职业信息我是写死的，不会影响到缓存*/
}
