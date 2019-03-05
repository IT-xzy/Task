package com.jnshu;

import com.jnshu.beans.Student;
import com.jnshu.mapper.StudentMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args ){

        Logger logger = LogManager.getLogger("App.class");
        ApplicationContext act =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        StudentMapper studentMapper = (StudentMapper) act.getBean("studentMapper");
        //logger.info("start select");


        //Student student = studentMapper.selectStuById(1);
        logger.info("start select");
        Student student = new Student();
        Long startTime = System.currentTimeMillis();
        studentMapper.selectStuById(666);
        studentMapper.selectStuById(6666);
        studentMapper.selectStuById(66666);
        studentMapper.selectStuById(666666);

//        for (int i = 0; i < (10 * 1000); i++) {
//            student.setName("teststu" + i);
//            student.setQq(111111 + i);
//            student.setOnlineNumber(6666 + i);
//            student.setLink("www.baidu.com");
//            student.setSchool("ncut");
//            student.setTeacher("zjz");
//            student.setTime("123321");
//            student.setType("java");
//            student.setWhereKonw("bihu");
//            student.setWish("upup");
////            studentMapper.addStu(student);
//            list.add(student);
//        }
//        System.out.println("student" + student);

//        System.out.println( "Hello World!" );
        logger.info("end select");
        Long  endTime = System.currentTimeMillis();

        Long useTime = endTime - startTime;

        logger.info(useTime);

    }
}
