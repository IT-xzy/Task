package com.listener;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: Arike
 * @program: task8-server
 * @description: 注解测试,这个是对应bean的,在bean类加载的时候执行,也就是说这个bean不能是懒加载.
 * @create: 2018/2/28 11:54
 */

@Component
public class MyListener1 {
    @PostConstruct
    public void run(){
        System.out.println("加载驱动");
    }
}
