package com.lyh;




import com.lyh.entity.Student;
import com.lyh.page.Page;
import com.lyh.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestTake {
    @Autowired
    StudentService studentService;
    @Test
    public void testSelect(){
        List<Student> students = studentService.listStudent();
        for (Student student :students){
            System.out.println(student);
        }
    }
    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("孟浩然");
        student.setStudentNumber(233);
        student.setQq("2891368077");
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨毁容");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        studentService.addStudent(student);
        System.out.println(student);
    }
    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setName("多目");
        student.setQq("486325");
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        student.setId(51);
        for (int i = 0; i < 10; i++) {
            studentService.updateStudent(student);
        }
    }
    @Test
    public void testDelete(){
        studentService.deleteStudent(50);
    }
    @Test
    public void pageStudent(){
        Page page = new Page();
        page.setStart(2);
        page.setCount(3);
        List<Student> cs=studentService.listPageStudent(page);
        for (Student student : cs) {
            System.out.println(student);
        }
    }
    @Test
    public void testByName(){
        List<Student> students = studentService.byName("江");
        for (Student student : students){
            System.out.println(student);
        }
    }
}
