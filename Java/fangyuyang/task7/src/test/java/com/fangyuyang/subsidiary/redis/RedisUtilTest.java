package com.fangyuyang.subsidiary.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void get() {
        System.out.println(redisUtil.get("name"));
    }

    @Test
    public void set() {
        System.out.println(redisUtil.set("1","12"));
    }
}