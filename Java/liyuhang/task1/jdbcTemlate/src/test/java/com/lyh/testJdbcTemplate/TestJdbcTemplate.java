package com.lyh.testJdbcTemplate;

import com.lyh.impl.StudentImpl;
import com.lyh.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class TestJdbcTemplate {
    private static org.apache.log4j.Logger logger = Logger.getLogger(Test.class);
//插入单条数据返回id
    @Test
    public void insert() {
        StudentImpl dao = new StudentImpl();
        Student student = new Student();
        student.setName("黎明");
        student.setQq(29803268);
        student.setWish("养活自己");
        student.setSchool("工业职业技术学院");
        student.setEnrolment_time(2018);
        student.setType("java");
        student.setKnow_from("知乎");
        student.setCreate_at(2018);
        student.setUpdate_at(20181022);
        dao.insert(student);
    }
    //批量插入id
    @Test
    public void insertBatch() {
        Student student = new Student();
        student.setName("黎明");
        student.setQq(29803268);
        student.setWish("养活自己");
        student.setSchool("工业职业技术学院");
        student.setEnrolment_time(2018);
        student.setType("java");
        student.setKnow_from("知乎");
        student.setCreate_at(2018);
        student.setUpdate_at(20181022);
        StudentImpl dao = new StudentImpl();
       for (int i = 1; i <= 1;i++) {
           for (int j = 1; j <= 3;j++){
            boolean s = dao.insertBatch(student);
               System.out.println("测试"+s);
   }
       }
    }
    //根据id删除数据并返回true/false
    @Test
    public void delete(){
        StudentImpl dao = new StudentImpl();
        dao.delete(100002);
    }
    //更新数据返回True/False
    @Test
    public void update(){
        Student student = new Student();
        student.setName("李杰");
        student.setId(100002);
        StudentImpl dao = new StudentImpl();
        boolean x = dao.update(student);
//        System.out.println("测试"+x);
    }
    //根据学员名字，学号去查找报名贴
    @Test
    public void selectByIdAndName(){
        StudentImpl dao = new StudentImpl();
        dao.selectByIdAndName("李海",100002);
    }
    //查询全表数据
    @Test
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class,isolation= Isolation.DEFAULT)
    public void selectAll(){
        StudentImpl dao = new StudentImpl();
        List<Student> students = dao.selectAll();
//        System.out.println(students);
        //List不能用foreach循环输出
        for (int i = 0;i < students.size();i++) {
            System.out.println(students.get(i));
        }
    }
}
