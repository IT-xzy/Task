package com.ptteng;

import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class MainTest {
    @Autowired
    StudentService studentService;

    //    插入对象
    @Test
    public void saveStudent() throws Exception {
        Student student = new Student("伍六一", "38114435", "JAVA工程师", "2017年1月6日", "保定学院", "JAVA-2871", "http://www.jnshu.com/daily/45199?dailyType=others&total=37&page=1&cid=661&sort=0&orderBy=3", "陷阵之志", "雍金卫", "知乎");
        Long currentTime = System.currentTimeMillis();
        student.setCreated_at(currentTime);
        for (int x = 1; x < 100000; x++) {
            studentService.saveStudent(student);
        }
    }

    //    删除对象
    @Test
    public void delete() throws Exception {
        studentService.removeStudent("王连喜");
    }

    //    修改对象
    @Ignore
    public void updateStudentTest() throws Exception {
        Student student = studentService.getStudentById(300L);
        student.setPledge("老大最帅");
        Long currentTime = System.currentTimeMillis();
        student.setUpdated_at(currentTime);
        if (studentService.updateStudent(student)){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }

    //    通过id获得单个对象
    @Test
    public void getStudentById() throws Exception {
        System.out.println(studentService.getStudentById(3L));
    }

    //    通过名字获得单个或多个对象
    @Test
    public void listStudentByName() throws Exception {
        System.out.println(studentService.getStudentByName("哈"));
    }

    //通过学号查询
    @Test
    public void getStudentByNumber() throws Exception{
        System.out.println(studentService.getStudentByNumber("JAVA-2871"));
    }
}