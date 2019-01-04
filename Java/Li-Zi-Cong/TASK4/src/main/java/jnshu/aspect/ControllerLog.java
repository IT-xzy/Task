package jnshu.aspect;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class ControllerLog {

    Logger logger = Logger.getLogger(ControllerLog.class);
    long time = 0;

    @Pointcut("execution(* jnshu.controller.HomePageCon.*(..))")
    public void say() {

    }

//    @Before("execution(* com.jnshu.dao.StudentInfoMapper.*(..))")
//    @Before("execution(* jnshu.controller.HomePageCon.*(..))")
//    public void beforeCON() {
//        time = System.currentTimeMillis();
//    }
//
//    @After("execution(* jnshu.controller.HomePageCon.*(..))")
//    public void afterCON(JoinPoint joinPoint) {
//        logger.error(" CON - method " + joinPoint.getSignature().getName() + " 耗时: " + (System.currentTimeMillis() - time));
//        System.out.println("---注解AOP后置"+"耗时: "+(System.currentTimeMillis()-time));
//    }


//    @Around("execution(* jnshu.controller.HomePageCon.*(..))")
//    public void arroundSay(ProceedingJoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        if (signature instanceof MethodSignature) {
//            MethodSignature methodSignature = (MethodSignature) signature;
//            Method method = methodSignature.getMethod();
//            System.out.println(method.getName() + "()方法开始时间：" + System.currentTimeMillis());
//
//            try {
//
//                System.out.println(method.getName() + "()方法结束时间：" + System.currentTimeMillis());
//                joinPoint.proceed();
//                System.out.println("222222222222222");
//            } catch (Throwable e) {
//
//            }
//        }
//    }


        @Around("execution(* jnshu.dao.StudentMapper.*(..))")
        public Object watchPerformance(ProceedingJoinPoint joinPoint) {
            Object object=null;
            try {
                object=joinPoint.proceed();
            } catch (Exception e) {
                e.printStackTrace();
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }
            return object;
        }

}
//    }

