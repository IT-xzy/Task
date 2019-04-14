package com.ptteng;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName enter
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/20  19:56
 * @Version 1.0
 **/
public class enter {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicaitonContext-dao.xml");
        System.out.println("服务启动!");


    }
}
