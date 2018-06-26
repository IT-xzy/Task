package com.task.tuscany.server;

public class HelloWord implements IHelloWorld {
    @Override
    public String sayHello(String world) {
        System.out.println("Hello"+world);
        return "Hello"+world;
    }
}
