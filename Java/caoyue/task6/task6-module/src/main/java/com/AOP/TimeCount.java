package com.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author: 曹樾
 * @program: task6-module
 * @description: 统计程序运行时间
 * @create: 2018/5/17 下午2:47
 */

@Component
@Aspect
public class TimeCount {
    Long startTime;
    Long endTime;
    Logger log = Logger.getLogger("TimeCount.class");
    @Pointcut("execution(* com.controller.StudentController.*(..))")
    private void tt(){}
    @Before("tt()")
    public Long start() throws InterruptedException {
        startTime = System.currentTimeMillis();
        log.info("开始执行："+startTime.toString());
        return startTime;
    }
    @After("tt()")
    public void time() {
        endTime = System.currentTimeMillis();
        Long count = endTime - startTime;
        log.info("执行结束"+endTime.toString());
        log.info("耗时"+count.toString());
    }
}
