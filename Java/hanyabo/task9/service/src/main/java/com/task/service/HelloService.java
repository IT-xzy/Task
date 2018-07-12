package com.task.service;


import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface HelloService {
    String sayHello(String msg);
}
