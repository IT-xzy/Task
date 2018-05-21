package cn.summerwaves.service.imp;

import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceImplTest {
    private static final Logger logger = Logger.getLogger(StudentServiceImplTest.class);

    @Resource
    private IStudentService studentService;

    @Test
    public void insertStudent() throws Exception {
        Student student = new Student();
        student.setName("fucker");
        studentService.insertStudent(student);
    }

    @Test
    public void fuck() {
        logger.error("fuck");
    }

}