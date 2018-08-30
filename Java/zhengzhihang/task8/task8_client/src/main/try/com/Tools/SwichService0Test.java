package com.Tools;
import com.pojo.Student;
import com.service.Service0;
import com.service.Service1;
import com.service.Service2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_rmi_client.xml")
public class SwichService0Test {

    private Service0 service0;

    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_rmi_client.xml");
        service0 = (Service1) applicationContext.getBean("service1");
        List<Student> list= service0.findStudent();
        System.out.println(list);
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_rmi_client.xml");
        service0 = (Service2) applicationContext.getBean("service2");
        List<Student> list= service0.findStudent();
        System.out.println(list);
    }


    @Test
    public void test3(){
        SwitchService swichService=new  SwitchService();
        service0= swichService.getService0();
        List<Student> list= service0.findStudent();
        System.out.println(list);
    }


}