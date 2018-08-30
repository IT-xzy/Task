//package com.aop;
//import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//public class TimeCost {
//    //日志
//    private  final Logger logger =Logger.getLogger(TimeCost.class);
//    //声明一个接入点
//    private static final String POINT = "execution (* com.*.*.*(..))";
//
//    //对切点方法进行增强
//    @Around(POINT)
//    public Object timeController(ProceedingJoinPoint pjp)  {
//        //获得目标类
//        Signature sig =pjp.getSignature();
//        MethodSignature ms;
//        if(!(sig instanceof MethodSignature)){
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        ms = (MethodSignature)sig;
//        String methodName=ms.getDeclaringTypeName()+"."+ms.getName();
//        //开始切入方法
//        logger.debug("#############方法开始执行#############");
//        //切入目标方法的开始时间
//        long startTime =System.currentTimeMillis();
//        //目标类/方法的执行
//        Object target = null;
//        try {
//            target = pjp.proceed();
//        } catch (Throwable a) {
//            logger.error("切入某方执行方法出错",a);
//        }
//        //方法执行完成的时间
//        long emdTime=System.currentTimeMillis();
//        //该方法执行的全部消耗时间
//        long timeCost=emdTime-startTime;
//        //输出日志
//        assert target != null;
//        logger.info("该类开始时间是"+startTime +
//                    "——————执行的方法是"+methodName+"————————执行的耗时是"
//                    + "( "+timeCost + " )"+"毫秒"+"————————执行结束的时间是"+emdTime);
//        return target ;
//    }
//
//
//}
