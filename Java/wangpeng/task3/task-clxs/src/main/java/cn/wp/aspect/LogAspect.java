//package cn.wp.controller;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName: cn.wp.controller.LogAspect
// * @Description:日志
// * @Author: 老王
// * @Date: 2019/5/11 11:28
// * @Version: 1.0
// */
//@Component//让这个类被spring当作一个bean管理
///**标明这个类是一个切面对象*/
//@Aspect
//public class LogAspect {
//    Logger logger = Logger.getLogger(LogAspect.class);
//
//    /**
//     * execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
//     */
//    @Around(value = "execution(public * cn.wp.controller.*.*(..))")
//    public Object timeFirst(ProceedingJoinPoint pjp) throws Throwable {
//        long t1 = System.currentTimeMillis();
//        Object[] arg = pjp.getArgs();
//        String method = pjp.getSignature().getName();
//        Object trage = pjp.getTarget();
////      调用 proceed() 方法才会真正的执行实际被代理的方法
//        Object result = pjp.proceed();
//        long t2 = System.currentTimeMillis();
//        logger.info("响应时间===============================================" + (t2 - t1));
//        logger.info("方法名=================================================" + method);
//        return result;
//    }
//
//    @Around(value = "execution(public * cn.wp.service.impl.*.*(..))")
//    public Object timeSecond(ProceedingJoinPoint pjp) throws Throwable {
//        logger.info("jinru1.......................................");
//        long t3 = System.currentTimeMillis();
//        Object[] arg = pjp.getArgs();
//        String method = pjp.getSignature().getName();
//        Object trage = pjp.getTarget();
//        Object result = pjp.proceed();
//        long t4 = System.currentTimeMillis();
//        logger.info("访问数据库时间===============================================" + (t4 - t3));
//        logger.info("方法名=================================================" + method);
//        return result;
//    }
//}
