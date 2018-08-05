package com.tool;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.danga.MemCached.MemCachedClient;

public class TestMemcache {
    MemCachedClient memCachedClient;
    @Before
    public void beforeTest(){
        ApplicationContext atx = new ClassPathXmlApplicationContext("spring-memcache.xml");
        memCachedClient = (MemCachedClient)atx.getBean("memCachedClient");
    }


    @Test
    public void TestMem(){
        memCachedClient.set("name", "han");

        System.out.println(memCachedClient.get("name"));
    }



}

