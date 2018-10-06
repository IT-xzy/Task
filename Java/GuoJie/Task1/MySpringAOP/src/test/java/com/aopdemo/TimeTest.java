package com.aopdemo;

import com.springAOP.MyMath;
import com.springAOP2.MyMath2;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@ContextConfiguration(locations = "classpath:springAOP2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeTest  {



   /* @Resource
    private MyMath myMath;*/
    @Resource
    private MyMath2 myMath2;

   /* @Test
    public void Test1(){
        int n1=100,n2=5;
        myMath.add(n1,n2);
    }*/
    @Test
    public void Test2(){
        int n1=100,n2=5;
        myMath2.del(n1,n2);
    }
}
