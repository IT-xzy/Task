package com.hzw.dao.impl;

import com.hzw.dao.StudentDao;
import com.hzw.pojo.Student;
import org.junit.Test;


import java.util.List;
import java.util.logging.Logger;

public class StudentDaoImplTest {

    static Logger looger = Logger.getLogger(String.valueOf(StudentDaoImplTest.class));

    @Test
    //增
    public void addStu() {
        looger.info("测试添加");
        StudentDao sd = new StudentDaoImpl();
        Student s = new Student();
        s.setS_name("月下无限连");
        s.setS_qq(267389401);
        s.setS_type("Web");
        s.setS_num(234);
        s.setCreate_at(System.currentTimeMillis());
        s.setUpdate_at(System.currentTimeMillis());
        long s_id = sd.addStu(s);
        looger.info("插入成功  Student id = "+s_id);
    }

    @Test
    //删
    public void deleteStu() {
        looger.info("测试删除");
        StudentDao sd = new StudentDaoImpl();
        long s_id = 10;
        sd.deleteStu(s_id);
    }

    @Test
    //改
    public void updateStu() {
        looger.info("测试更改");
        StudentDao sd = new StudentDaoImpl();
        Student s = new Student();
        s.setS_id(11);
        s.setS_name("跳跃三连击");
        s.setS_qq(66666666);
        s.setS_type("OP");
        s.setS_num(432);
        s.setUpdate_at(System.currentTimeMillis());
        sd.updateStu(s);
    }

    @Test
    //查ID
    public void getId() {
        looger.info("测试查询id");
        StudentDao sd = new StudentDaoImpl();
        Student s;
        long s_id = 1;
        s = sd.getId(s_id);
        System.out.println(s);
        looger.info(""+s);

    }

    @Test
    //综合查询
    public void getName(){
        looger.info("测试查询name");
        StudentDao sd = new StudentDaoImpl();
        String s_name = "月下无限连";
        int s_num = 234;
        List<Student> list = sd.getName(s_name,s_num);
        for(Student s:list){
            looger.info(s.toString());
        }
    }

    @Test
    //查全部
    public void getAll() {
        looger.info("测试查询全部");
        StudentDao sd = new StudentDaoImpl();
        List<Student> list = sd.getAll();
        for(Student s:list){
            looger.info(s.toString());
        }
    }
}
