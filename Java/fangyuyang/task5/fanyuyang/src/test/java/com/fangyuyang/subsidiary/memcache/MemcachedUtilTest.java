package com.fangyuyang.subsidiary.memcache;

import com.fangyuyang.dao.CareerMapper;
import com.fangyuyang.dao.UserMapper;
import com.fangyuyang.service.CareerService;
import com.fangyuyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MemcachedUtilTest {
    @Resource
    private MemcachedUtil memcachedUtil;
    @Resource
    private UserService userService;
    @Resource
    private CareerService careerService;

    @Test
    public void findCareerById() {
        System.out.println("ceshi"+careerService.findCareerById(14));
    }
    @Test
    public void set() {
        memcachedUtil.set("13",userService.findUserById(13),36000);

    }
    @Test
    public void get() {

        System.out.println(userService.memCacheGet("24"));
    }

    @Test
    public void replace() {
    }

    @Test
    public void add() {
    }

    @Test
    public void cas() {

        if(!memcachedUtil.cas("20",36000,memcachedUtil.get("20")))
        {

            System.out.println("无缓冲"+userService.findUserById(27).getName());
        }else {
            System.out.println(memcachedUtil.get("20"));
        }

    }
}