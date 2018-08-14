package com.jnshu.Rmi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: Tiles
 * @description:
 * @author: Mr.Lee
 * @create: 2018-08-08 22:48
 **/
public class RmiTest {
    public static void main(String args[]){
        new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("服务端RMI启动 端口号");
    }
}
