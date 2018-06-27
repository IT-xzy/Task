package com.fml.aop.test;

import org.springframework.stereotype.Component;

@Component("helloWorldImpl")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
    }
}
