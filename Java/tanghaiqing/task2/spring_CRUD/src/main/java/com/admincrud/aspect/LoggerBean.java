package com.admincrud.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerBean {
    @Before("within(com.admincrud.controller..*)")
    public void logController(){
        System.out.println("AOP功能注入！");
    }
}
