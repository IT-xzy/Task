package com.myitschool.cache;

import com.myitschool.redisUtil.RedisUtil;
import com.myitschool.student.Student;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

//import java.util.logging.Logger;
@Aspect
@Component
public class RedisAspect {


//    @Autowired
//    private RedisTemplate<String, List<Student>> redisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private final Logger logger = Logger.getLogger(RedisTemplate.class);

    private static boolean flag = false;

    private final String KEY = "allStudent";

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

//        //测试集群
//        for(int i = 0; i < 100; i++){
//            redisTemplate.opsForValue().set("string哈哈" + i, i);
//            System.out.println(redisTemplate.opsForValue().get("string哈哈" + i));
//        }




        if (KEY != method.getName()) {
            result = pjp.proceed();
            flag = true;
        } else {
            try {
                if(flag || !redisTemplate.hasKey(KEY)) {
                    redisTemplate.delete(KEY);
//                    redisTemplate.opsForList().leftPush(KEY, (List<Student>)pjp.proceed());
                    redisTemplate.opsForList().rightPushAll(KEY, (List<Student>)pjp.proceed());
                    logger.info("update");
                }
//                result = redisTemplate.opsForList().leftPop(KEY);
                result = redisTemplate.opsForList().range(KEY, 0, -1);
                logger.info("search all from redis");
            } catch (Exception e) {
                e.printStackTrace();
                result = pjp.proceed();
                logger.info("search all from mysql");
            }
            flag =false;
        }
        return result;
    }
}
