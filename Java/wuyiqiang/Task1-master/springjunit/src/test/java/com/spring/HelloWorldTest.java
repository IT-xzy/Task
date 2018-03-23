package com.spring;

import com.spring.junit.HelloWorld;
import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void sayHello() {
        HelloWorld hello = new HelloWorld();
        Assert.assertEquals("Say hello mehtod test failed.", "hello,maven!", hello.sayHello("maven"));
    }
}