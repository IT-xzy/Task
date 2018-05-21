package com.fml.aop.test;

import org.springframework.stereotype.Component;

@Component("helloWorldImpl")
public interface HelloWorld {
    void printHelloWorld();
    void doPrint();
}
