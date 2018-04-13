package com.ssm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    //50ms
    private static final long TIME=50;

    //controller层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    public static final String POINT = "execution (* com.ssm.controller.*.*(..))";
    /**
     * 统计方法执行耗时Around环绕通知
     */
    @Around(POINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) {
//         定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }

        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }


    /**
     * 打印方法执行耗时的信息
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
//        if (diffTime>TIME) {
//            logger.info("-----------" + methodName + " 方法执行耗时:" + diffTime + " ms");
//        }
        logger.info("-----------" + methodName + "方法执行耗时 " + diffTime + " ms");
    }

}
