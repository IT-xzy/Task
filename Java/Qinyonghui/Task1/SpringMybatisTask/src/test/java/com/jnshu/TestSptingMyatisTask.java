package com.jnshu;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSptingMyatisTask {
    @Autowired
        StudentDao studentDao;
    @Test
    public void insertTest(){
        Student student = new Student("许仙", 12313243, 1342432, "hfgirhei", "isfdjfjgodfjogjos", "东北大学", System.currentTimeMillis(),System.currentTimeMillis());
        studentDao.insert(student);
        System.out.println(student.getId());
    }
    @Test
    public void deleteTest(){
//        UseDao userMapper = context.getBean(UseDao.class);
        boolean flag = studentDao.delete(1L);
        System.out.println(flag);
    }
    @Test
    public void updateTest(){
//        UseDao userMapper = this.context.getBean(UseDao.class);
        Student student = new Student(5l, "wuieryuidfwerwe", 124, 12432, "hhdfgskgh", "dfgsdgfg", "fsdfdsfg", System.currentTimeMillis());
        boolean flag = studentDao.update(student);
        System.out.println(flag);
    }
        @Test
        public void findTest() {
       /*UseDao userMapper = context.getBean(UseDao.class);// 获取Mapper*/
            Student student = studentDao.find(5);
            System.out.println(student);
        }
    @Test
    public void findAll(){
//        UseDao userMapper = context.getBean(UseDao.class);
        List studentlist = studentDao.findAll();
        System.out.println(studentlist);
    }
    }
