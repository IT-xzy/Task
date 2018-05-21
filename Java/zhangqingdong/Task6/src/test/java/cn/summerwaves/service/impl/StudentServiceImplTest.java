package cn.summerwaves.service.impl;

import cn.summerwaves.dao.StudentDao;
import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceImplTest {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectAllStudentFromDB() throws Exception {
        List<Student> students = studentService.selectThreeStudent();
        for (Student student : students) {
            System.out.println(student.getName());

        }
    }

    @Test
    public void test() {
        Student student = new Student();
        student.setName("fuckyou");
        studentDao.insertStudent(student);
    }
}