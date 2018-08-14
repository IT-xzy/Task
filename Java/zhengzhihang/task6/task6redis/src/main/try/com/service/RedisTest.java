package com.service;

import com.interceptor.RedisTool;
import com.interceptor.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)//让测试运行于spring测试环境
@ContextConfiguration(locations="classpath:spring-redis.xml")
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;
    RedisUtil rd;
    private static long time=1111111;
    RedisTool rt;

    RedisUtil redisUtil;
    @Test
    public void testRedis() {
        redisTemplate.boundValueOps("zhangsan").set("张三",12,TimeUnit.SECONDS);
        String str = (String) redisTemplate.boundValueOps("zhangsan").get();
        System.out.println(str);
    }

    @Test
    public void test(){
        redisTemplate.opsForValue().set("zz","pp",time,TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("zz"));
    }

    @Test
    public void test2(){
        redisTemplate.opsForValue().set("cc","aa",time,TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("cc"));
    }

    @Test
    public void test3(){
        RedisTool.rdSet("123","1",time);
        System.out.println(redisTemplate.opsForValue().get("123"));
    }

    @Test
    public void test4(){
        boolean i= RedisTool.rdGetKey("55");
        if(i){
            System.out.println("这个存在，ture");
        }else {
            System.out.println("这个不存在 false");
        }
    }

    @Test
    public void test5(){
        System.out.println(RedisTool.rdGet("123"));
    }

    @Test
    public void  test6(){
        RedisTool.rdSet("22",null,123);
        System.out.println(RedisTool.rdGet("88"));
    }

}