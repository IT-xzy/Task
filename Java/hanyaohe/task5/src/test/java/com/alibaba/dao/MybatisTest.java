package com.alibaba.dao;


import com.alibaba.model.Count;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class MybatisTest {
//    @Resource
//    private com.alibaba.dao.CountMapper countMapper;
//
//    @Test
//    public void deleteByPrimaryKey() {
//        countMapper.deleteById(25919);
//        // System.out.println(s);
//    }
//
//
//    @Test
//    public void insert() {
//        Count student = new Count();
//        student.setId(18);
//        student.setOnline("25");
//        student.setWorkers("617");
//        student.setUser("95");
//        student.setPass("84");
//        countMapper.insert(student);
//        System.out.println(student);
//    }
//
//    @Test
//    public void update() {
//        Count student = new Count();
//        student.setId(3);
//        student.setPass("8");
//        student.setUser("82");
//        student.setWorkers("5497864");
//        student.setOnline("7458");
//        countMapper.updateById(student);
//    }
//
//    @Test
//    public void selectById() {
//        Count student = countMapper.selectById(5);
//        System.out.println(student);
//    }
//}
//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Resource
    private CountMapper countMapper;

    @Test
    public void add() {
        Count count = new Count();
        count.setId(100);
        count.setOnline("45");
        count.setUser("74");
        count.setMd5("7545");
        count.setSalt("985");
        count.setWorkers("559");
        count.setPass("864");
        countMapper.insert(count);
        System.out.println(count);
    }
    @Test
    public void delCount(){
        countMapper.deleteById(5);
    }
    @Test
    public void updateCount(){
        Count count = new Count();
        count.setPass("98");
        count.setWorkers("894");
        count.setSalt("24");
        count.setMd5("544");
        count.setUser("7845");
        count.setOnline("554");
        countMapper.updateById(count);
    }
}