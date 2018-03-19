package com.student.util;

import com.student.model.Student;
import com.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RedisUtilTest {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private StudentService studentService;

    @Test
    public void haskey() {
        redisUtil.haskey("hahaha");
    }

    @Test
    public void del() {
        redisUtil.del("studentList");
    }

    @Test
    public void get() {
        System.out.println(redisUtil.get("studentList"));
//        System.out.println(redisUtil.lGet("studentList",0,-1));
    }

    @Test
    public void set() {

        List<Student> studentList = studentService.getAll();
        redisUtil.set("studentList", studentList);


    }
}