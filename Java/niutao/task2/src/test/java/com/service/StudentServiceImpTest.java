package com.service;

import com.util.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class StudentServiceImpTest {

    @Autowired
    StudentService studentService;

    @Test
    public void getTotal() {
        Page page = new Page();
        page.caculateLast(studentService.getTotal());
        System.out.println(studentService.getStudentListByPage(page));
    }

    @Test
    public void getStudentListByPage() {
    }
}