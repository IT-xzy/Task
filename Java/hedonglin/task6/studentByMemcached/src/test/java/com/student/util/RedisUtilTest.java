package com.student.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RedisUtilTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void haskey() {
        redisTemplate.hasKey("hahaha");
    }

    @Test
    public void del() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }
}