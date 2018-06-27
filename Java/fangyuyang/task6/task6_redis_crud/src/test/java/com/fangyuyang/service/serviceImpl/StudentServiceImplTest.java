package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.redis.RedisUtil;
import com.fangyuyang.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void redisGet() {
        redisUtil.set("name", "王赛超");
        System.out.println(studentService.findStudentById(3));
        redisUtil.set("3",studentService.findStudentById(3));
       redisUtil.get("4");
    }
}