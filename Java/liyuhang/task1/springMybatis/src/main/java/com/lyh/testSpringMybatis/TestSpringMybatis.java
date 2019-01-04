package com.lyh.testSpringMybatis;

import com.lyh.mapper.StudentMapper;

import com.lyh.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//用来指定加载的Spring配置文件的位置，加载默认的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringMybatis {
    @Autowired
//    注解注入接口
    private StudentMapper studentMapper;
    //插入数据并返回自增长id
    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("孟浩然");
        student.setQq(17540990);
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨毁容");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        studentMapper.addStudent(student);
        System.out.println("新增id ：" + student.getId());
    }
    //根据id删除数据
    @Test
    public void testDeleteStudent(){
        int x = studentMapper.deleteStudent(100003);
        if (x != 0){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    //根据id修改数据
    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setName("李白");
        student.setQq(17540990);
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨毁容");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        student.setId(100003);
        int x = studentMapper.updateStudent(student);
        if (x != 0){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    //根据学员学号查找报名帖
    @Test
    public void selectByIdAndName(){
        List<Student> students = studentMapper.selectById(100003);
        for (Student student : students){
            System.out.println(student);
        }
    }
    //根据学员名字查找报名帖
    @Test
    public void selectByName(){
        List<Student> students = studentMapper.selectByName("黎明");
        for (Student student : students){
            System.out.println(student);
        }
    }
    //查询全部数据
    @Test
    public void selectAll(){
        List<Student> students = studentMapper.selectAll();
        for (Student student : students){
            System.out.println(student);}

    }
}
