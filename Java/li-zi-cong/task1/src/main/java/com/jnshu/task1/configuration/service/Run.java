package com.jnshu.task1.configuration.service;

import com.jnshu.task1.configuration.dao.StudentInfoMapper;
import com.jnshu.task1.configuration.pojo.StudentInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Run {
    private ApplicationContext
            applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    StudentInfoMapper studentInfoMapper = (StudentInfoMapper)applicationContext.getBean("userMapper");

    @Test
    public void Test(){
        System.out.println(new Date());
    }

    @Test
    public void insertSTU(){
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentName("李1聪");
            studentInfo.setQq(845634109);
            studentInfo.setLearnType("JAVA");
            studentInfo.setJoinTime(new Date());
            studentInfo.setSchool("佛山技术学院");
            studentInfo.setStudentID(165);
            studentInfo.setLink("www.jnshu.com");
            studentInfo.setMotto("为往圣继绝学");
            studentInfo.setBrother("娄文彬");
            studentInfo.setKnowFrom("知乎");
            System.out.println("插入的信息"+ studentInfo);
            Integer index = studentInfoMapper.insertSTU(studentInfo);
            System.out.println("影响行数:"+index+"\t插入返回的主键:"+ studentInfo.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteSTU() {
        try {
            studentInfoMapper.deleteByID(11);
        } catch (Exception e) {
            e.printStackTrace();
        }//测试完毕
    }
    @Test
    public void listTable() {
        try {
            System.out.println("查询列表:");
            List<StudentInfo> studentInfos = studentInfoMapper.listTable();
            //studentInfos.toString();
            for (StudentInfo studentInfo : studentInfos){
                System.out.println(studentInfo.toString());
            }
        }catch (Exception e){

        }
    }
    @Test
    public void updateByID(){
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentName("李梓聪");
            studentInfo.setQq(845634109);
            studentInfo.setLearnType("JAVA");
            studentInfo.setJoinTime(new Date(2018,7,7));
            studentInfo.setSchool("佛山技术学院");
            studentInfo.setStudentID(165);
            studentInfo.setLink("www.jnshu.com");
            studentInfo.setMotto("为往圣继绝学");
            studentInfo.setBrother("娄文彬");
            studentInfo.setKnowFrom("知乎");
            System.out.println("修改的信息"+ studentInfo);
            studentInfo.setId(12);
            studentInfoMapper.updateByID(studentInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findByLikeName(){
        try {
           List<StudentInfo> studentInfos = studentInfoMapper.findByLikeName("李梓聪");
            System.out.println("姓名模糊查询结果:");
           for (StudentInfo studentInfo : studentInfos){
               System.out.println(studentInfo);
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findByStudentID(){
        try {
            StudentInfo studentInfo =studentInfoMapper.findByStudentID(18);
            System.out.println("ID查询结果:"+ studentInfo);
        }catch (Exception e){

        }
    }
}




