package com.spring.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld hello = new HelloWorld();
        assertEquals("Say hello mehtod test failed.", "hello,maven!", hello.sayHello("maven"));
    }
}
