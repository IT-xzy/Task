package com.controller;

import com.entity.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;
import com.utils.StudentUtil;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/8 18:20
 * @version: [1.0]
 */
public class StudentController {
    /**写在程序启动之前：去掉所有的注解。如果要Junit测试spring整合mybatis，加上注解，去掉所有的读取配置文件*/

    private static final Logger logger = Logger.getLogger(StudentController.class);

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();

        /**向数据库中插入20条记录*/
        for (int i = 0; i < 5; i++){
            Student student = StudentUtil.newStudent("张三");
            int result = studentService.add(student);
            //System.out.println(result);
            logger.info("add student's id is " + result);
        }
        for (int i = 0; i < 5; i++){
            Student student = StudentUtil.newStudent("李四");
            int result = studentService.add(student);
            logger.info("add student's id is " + result);
        }
        for (int i = 0; i < 5; i++){
            Student student = StudentUtil.newStudent("王五");
            int result = studentService.add(student);
            logger.info("add student's id is " + result);
        }
        for (int i = 0; i < 5; i++){
            Student student = StudentUtil.newStudent("赵六");
            int result = studentService.add(student);
            logger.info("add student's id is " + result);
        }
        for (int i = 0; i < 5; i++){
            Student student = StudentUtil.newStudent("宋七");
            int result = studentService.add(student);
            logger.info("add student's id is " + result);
        }
        logger.info("Added a total of 20 students");

        /*遍历所有学员姓名
        List<Student> list = studentService.selectAll();
        for (Student student : list){
            System.out.println(student.getStuName());
        }*/

        /**删除之前去数据看看看有没有这个ID*//*
        Student student = studentService.selectById(454);
        logger.info("chosen student's primary is " + student.getId());*/

        /**模糊查询，姓名中带三的*/
        List<Student> students = studentService.selectByName("三");
        logger.info("Here are three people whose name contains " + "三");
        for (Student stu : students){
            //System.out.println(stu.getStuName());
            logger.info(stu.getStuName());
        }


        int result = studentService.add(StudentUtil.newStudent("哈哈哈"));
        Student student = studentService.selectById(result);
        logger.info(student.getStuName());
        /**将根据ID查询出的学员愿望改为 欲买桂花同载酒，终不似，少年游*/
        student.setWish("少年游");
        studentService.update(student);
        logger.info(student.getWish());


        /**查找出所有的学员信息*/
        //List<Student> students = studentService.selectAll();

        /**查找出学员总数*/
        int count = studentService.selectCount();
        logger.info("The total number of students is " + count);

        /**删库跑路*/
        String deleteResult = studentService.deleteAll();
        logger.info("delete all students data " + deleteResult);
    }
}
