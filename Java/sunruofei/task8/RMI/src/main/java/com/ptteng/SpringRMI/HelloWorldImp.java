package com.ptteng.SpringRMI;

/**
 * @ClassName HelloWorldImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  23:28
 * @Version 1.0
 **/
public class HelloWorldImp implements HelloWorld {
    @Override
    public String helloWorld() {
        return "HelloWorld";
    }

    @Override
    public String sayHelloToSomeBody(String someBodyName) {
        return "Hello World!" + someBodyName;
    }

}
