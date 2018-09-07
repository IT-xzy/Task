package com.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AopImpl {
    private static Log logger = LogFactory.getLog(AopImpl.class);
    private static final long ONE_MINUTE = 0;

    //public AopImpl() {
    //    logger.info("-------------------------");
    //}
    // service层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    //public static final String POINT = "execution (* com.controller.PaperController.*(..))";

    /**
     * 统计方法执行耗时Around环绕通知
     *
     * @param joinPoint
     * @return
     */

    @Around("execution (* com.service.impl.PaperServiceImpl.*(..))")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        logger.info("---进入Database类方法切面中---\n\n");
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();

        //时间格式转换
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startTime = System.currentTimeMillis();
        Date date = new Date(startTime);
        logger.info("---开始执行时间:"+formatter.format(date));
        try {
            obj = joinPoint.proceed(args);
            //logger.info("---获取obj对象值："+obj);
        } catch (Throwable e) {
            logger.error("---统计DataBase方法执行耗时环绕通知出错---", e);
        }

        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        logger.info("---结束切入---\n\n");
        return obj;
    }

    /**
     *源代码是 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     *现在修改成方法执行的时间
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        if (diffTime > ONE_MINUTE) {
            logger.info(methodName + " DB 类方法执行耗时: " + diffTime);
        }
    }


}



