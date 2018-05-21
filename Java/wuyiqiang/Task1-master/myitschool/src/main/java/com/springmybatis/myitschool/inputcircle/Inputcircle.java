package com.springmybatis.myitschool.inputcircle;

import com.springmybatis.myitschool.DAO.StudentDAO;
import com.springmybatis.myitschool.student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inputcircle {

    public static void main(String[] args) {

        ApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO stuDAO = (StudentDAO) ctx.getBean(StudentDAO.class);

        Student stu = new Student();
        stu.setName("小xiao强");
        stu.setQQ(1111110);
        stu.setType("java");
        stu.setStime("20180105");
        stu.setGraschool("北大幼儿园");
        stu.setClassnum("11111");
        stu.setLink("www.baidu.com");
        stu.setMentor("hahahh");
        stu.setConbrother("大强");
        stu.setHknow("微信");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            stuDAO.insertStudent(stu);
        }
        System.out.println("waste time:  "+(System.currentTimeMillis()-start)/1000);
    }
}
