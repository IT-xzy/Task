package com.service.impl;

import com.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author Arike
 * Create_at 2017/12/18 9:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ServiceImplTest {
    @Autowired
    ServiceImpl service;
    @Test
    public void selectAll() throws Exception {
        
        System.out.println(service.selectAll());
    }
    
    @Test
    public void test()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(1478240064901L));
    }
    
    @Test
    public void selectCount() {
        for(int i = 0; i <50; i++) {
            String[] arr ={"泰兰德","瓦里安","吉安娜","安度因","萨尔"};
            Random r = new Random();
        service.insertStudent(new Student(null,System.currentTimeMillis(),null,arr[r.nextInt(5)],"909080","圣骑士",System.currentTimeMillis(),"暴风城","coolman","baofengche.com","为了联盟","泰兰德的软香蕉","泰达希尔"));
        
        }
        
    }
    
}