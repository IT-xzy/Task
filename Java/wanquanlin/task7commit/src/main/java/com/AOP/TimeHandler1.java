package com.AOP;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author: Jaime
 * @Date: 2018/4/10 15:46
 * @Description: 切面类*
 */
@Component("annotationTest")
@Aspect
public class TimeHandler1 {
    Long a;
    Long b;
    Logger log= LoggerFactory.getLogger("TimeHandler1.class");
//    ("execution(* com.controller.LoginController.*(..))")
    @Pointcut("execution(* com.service.LoginServiceImpl.*(..))")
    private void tt(){}
    @Before("tt()")
    public Long time1() throws InterruptedException {
        a=System.currentTimeMillis();
        log.info("开始执行："+a.toString());
        return a;
    }
    @After("tt()")
    public void time22(){
        b=System.currentTimeMillis();
        Long c=b-a;
        log.info("执行结束"+b.toString());
        log.info("耗时"+c.toString());
    }
}
