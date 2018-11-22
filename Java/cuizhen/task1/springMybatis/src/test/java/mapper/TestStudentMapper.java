package mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TestStudentMapper {
    @Autowired
    private StudentMapper studentMapper;
    private static Logger logger = Logger.getLogger(String.valueOf(TestStudentMapper.class));

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("九回家开");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(88);
        studentMapper.addStudent(student);
        logger.info("id=" + student.getId());
    }


    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setName("九块");
        student.setQq(12132);
        student.setType("九块九");
        student.setTime("ds");
        student.setGraduateInstitutions("jjj");
        student.setDailyLink("kj");
        student.setVolunteer("kjk");
        student.setCreateAt(77);
        student.setUpdateAt(77);
        student.setId(71);
        int i = studentMapper.updateStudent(student);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
    }

    @Test
    public void testDeleteStudent() {
        int i = studentMapper.deleteStudent(1);
        if (i != 0) {
            logger.info("true");
        } else {
            logger.info("false");
        }
    }

    @Test
    public void testSelectStudent() {
        Student student = studentMapper.selectStudent(70);
        logger.info("" + student);
    }

    @Test
    public void testSelectStudentName() {
        List<Student> students = studentMapper.selectStudentName("九块九");
        logger.info("" + students);
    }

    @Test
    public void testFindAllStudent() {
        List<Student> students = studentMapper.findAll();
        for (Student student:students) {
            logger.info("" + student);
        }
    }
}
