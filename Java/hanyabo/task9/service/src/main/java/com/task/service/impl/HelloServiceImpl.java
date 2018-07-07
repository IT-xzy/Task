package com.task.service.impl;

import com.task.service.HelloService;

public class HelloServiceImpl implements HelloService {

    public String sayHello(String msg) {
        System.out.println("服务端接收消息："+msg);

        return "hello-->"+msg;
    }
}

