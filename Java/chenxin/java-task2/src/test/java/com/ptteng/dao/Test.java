package com.ptteng.dao;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Test {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentService studentService;
    @org.junit.Test
    public void get() throws Exception{
        System.out.println(studentDao.getAllStudents());
    }
    @org.junit.Test
    public void getCount() throws Exception{
        System.out.println(studentDao.getCount());
    }
    @org.junit.Test
    public void insert() throws Exception{
        Student student=new Student("燕小鱼","11111","前端工程师","2016年3月7日","北京天天蓝大学天天玩技术学院","8906","http:www.jnshu.com/77892/","如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！","任我行","知乎");
        for (int i=3;i<5;i++){
            long createTime=System.currentTimeMillis();
            student.setCreated_at(createTime);
        System.out.println(studentDao.saveStudent(student));
        }
        System.out.println(student.getId());
    }
    @org.junit.Test
    public void inserts() throws Exception{
        Student student=new Student("dsa","","","","","","","","","");
        System.out.println(studentService.saveStudent(student));
        System.out.println(student.getId());
    }
    @org.junit.Test
    public void  delete() throws Exception{
        System.out.println(studentService.deleteStudentById(16L));
    }
}
