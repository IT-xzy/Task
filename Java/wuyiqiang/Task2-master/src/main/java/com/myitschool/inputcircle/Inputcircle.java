package com.myitschool.inputcircle;

import com.myitschool.DAO.StudentDAO;
import com.myitschool.student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inputcircle {

    public static void main(String[] args) {

        ApplicationContext ctx = null;
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO stuDAO = (StudentDAO) ctx.getBean(StudentDAO.class);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            String name = "张" + i;
            Student stu = new Student();
            stu.setName(name);
            stu.setQq(i);
            stu.setType("java");
            stu.setStime("20180105");
            stu.setGraschool("北大幼儿园");
            stu.setClassnum("11111");
            stu.setLink("www.baidu.com");
            stu.setMentor("hahahh");
            stu.setConbrother("大强");
            stu.setHknow("微信");

            stuDAO.insertStudent(stu);
        }
        System.out.println("waste time:  "+(System.currentTimeMillis()-start)/1000);
    }
}
