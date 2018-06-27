package com.fgh.task2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.xml.crypto.Data;

/*
当启用了@AspectJ支持后，只要在Spring容器中配置一个带@AspectJ注释的Bean，
Spring将会自动识别改Bean,并将该bean作为切面处理。
 */

/*
切面类（用@Aspect修饰类）和其他类一样可以有方法和属性的定义，还能包括切入点、
增强处理的定义。当我们使用@Aspect来修饰一个Java类后，Spring将不会把该Bean当成组件Bean处理，
因此当Spring容器检测到某个Bean使用了@AspectJ标注之后，负责自动增强的Bean后处理将会忽略该Bean，
不会对该Bean进行任何增强处理。
 */
@Aspect
public class LogAspect {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /*
    使用@Before标注时，通常需要指定一个value属性值，该属性值指定一个切入点，用于
    指定该增强处理将被哪些切入点
     */
    @Before(value = "execution(* com.fgh.task2.service.UserService.findAll(..))")
    public void doBefore(){
        logger.info("---------------Before-----------------");
    }

    

}
