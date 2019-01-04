package dao;

import dao.impl.StudentDaoImpl;
import org.junit.Test;
import pojo.Student;

import java.util.List;
import java.util.logging.Logger;

public class StudentDaoTest {
    StudentDaoImpl studentImpl = new StudentDaoImpl();
    private static Logger logger = Logger.getLogger(String.valueOf(StudentDaoTest.class));

    @Test
    public void testAddStudent() throws Exception {
        Student student = new Student();

        student.setName("我");
        student.setQq(12321);
        student.setType("快到家");
        student.setTime("2018.11.11");
        student.setGraduateInstitutions("但是解放军");
        student.setDailyLink("高仿");
        student.setVolunteer("高仿");
        student.setCreateAt(1);
        student.setUpdateAt(2);

        long key = studentImpl.add(student);
        logger.info("key=" + key);
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setName("放箭放箭");
        student.setQq(123);
        student.setType("1354");
        student.setTime("45465");
        student.setGraduateInstitutions("4546");
        student.setDailyLink("4546");
        student.setVolunteer("445");
        student.setCreateAt(122);
        student.setUpdateAt(159);
        student.setId(80);
        boolean bl= studentImpl.update(student);
        logger.info("" + bl);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        long id = 4;
        boolean i = studentImpl.delete(id);
        logger.info("" + i);
    }

    @Test
    public void testGetStudent() throws Exception {
        long id = 8;
        Student student = studentImpl.get(id);

        logger.info("" + student);
    }

    @Test
    public void testGetStudent1() throws Exception {
        String name = "九块九";
        List<Student> students = studentImpl.get(name);

        for (Student student : students) {
            logger.info("student = " + student);
        }
    }

    @Test
    public void testSelectStudent() throws Exception {
        List<Student> students = studentImpl.selectStudent();

        for (Student student : students) {
            logger.info("student = " + student);
        }

    }
}