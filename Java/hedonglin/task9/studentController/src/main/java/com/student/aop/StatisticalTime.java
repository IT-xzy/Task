package com.student.aop;

import com.student.service.StudentService;
import com.student.util.SelectRMI;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class StatisticalTime {

    private Long dBStart;
    private Long controllerStart;
    private  Logger logger = LoggerFactory.getLogger(StatisticalTime.class);
//
//    @Before("execution(* com.student.service.StudentService.*(..))")
//    public void startTime() {
//        dBStart = System.currentTimeMillis();
//    }
//
//    @After("execution(* com.student.service.StudentService.*(..))")
//    public void endTime() {
//        Long end = System.currentTimeMillis();
//        logger.info("开始时间=" + dBStart +"ms"+ "结束时间=" + end +"ms"+ "访问DB用时=" + "\t"+(end - dBStart)+ "\t" + "ms"+"\t"+"查询访问DB用时");
//    }




    @Before("execution(* com.student.controller.StudentController.*(..))")
    public void controllerStartTime(){
        controllerStart=System.currentTimeMillis();
    }


    @After("execution(* com.student.controller.StudentController.*(..))")
    public void controllerEndTime(){
        Long end=System.currentTimeMillis();
        logger.info("开始时间="+ controllerStart+"ms"+"结束时间="+end+"ms"+"Controller处理时间="+"\t"+(end - controllerStart)+ "\t"+"ms"+"\t"+"查询控制器处理时间");
    }



}
