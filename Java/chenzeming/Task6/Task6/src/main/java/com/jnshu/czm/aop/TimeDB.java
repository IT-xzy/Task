package com.jnshu.czm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;



@Aspect
@Component
public class TimeDB {
    //日志的使用
    private static Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    /**
     * 统计方法执行耗时Around环绕通知
     */
    @Around(value = "execution(* com.jnshu.czm.service.impl.UserServiceImpl.*(..))")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        //    定义返回对象、得到方法需要的参数
        //    这个模块是

        Object obj = null;
        Object[] args = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();

        /**
         * 这是个时间格式的转换，方便观察，加入这个是为了更进一步的观察around环绕通知的执行顺序
         */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        Date date = new Date(startTime);
        System.out.println("DB的访问时间："+formatter.format(date));

        //执行目标方法，也就是执行controller里面的方法
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("\n"+"统计某方法执行耗时环绕通知出错", e);
        }


        long endTime = System.currentTimeMillis();
        // 获取执行的方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        // 打印方法的耗时信息
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    /**
     * 打印方法执行耗时的信息
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;

        logger.info("\n"+"-----------" + methodName + "访问耗时 " + diffTime + " ms");
    }
}


