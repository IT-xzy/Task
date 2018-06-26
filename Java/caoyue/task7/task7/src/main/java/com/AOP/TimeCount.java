package com.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

/**
 * @author: 曹樾
 * @program: task7
 * @description: use AOP to count the consumption of time
 * @create: 2018/5/28 下午1:36
 */

public class TimeCount {
    Long startTime;
    Long endTime;
    Logger log = Logger.getLogger("TimeCount.class");
    @Pointcut("execution(* com.controller.RegisterController.testjson())")
    private void tt(){}
    @Before("tt()")
    public Long start(){
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
