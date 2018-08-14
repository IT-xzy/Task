package com.tools;

import com.danga.MemCached.MemCachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-memcache.xml")
public class MemcacheTest {

    private static MemCachedClient memCachedClient;
    static {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-memcache.xml");
        memCachedClient= (MemCachedClient) ap.getBean("memCachedClient");
    }
    String key="123";
    String o="ob";
    long time=20000;

    @Test
    public void add(){

        boolean i= Memcache.addKey("123","123123",20000);
        System.out.println(i);


    }
    @Test
    public void set(){
        boolean i = Memcache.setKey(key,o,time);
        System.out.println(i);
        System.out.println(Memcache.getKey(key));
    }

    @Test
    public void emptyTest(){
        Memcache.setKey("empty",null,20000);
        System.out.println(Memcache.getKey("empty"));
    }
}