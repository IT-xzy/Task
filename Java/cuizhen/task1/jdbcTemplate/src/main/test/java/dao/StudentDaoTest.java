package dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StudentDaoTest {
    ApplicationContext applicationContext=new
            ClassPathXmlApplicationContext("applicationContext.xml");
    StudentDao dao=(StudentDao) applicationContext.getBean("studentDao");
    private static Logger logger =Logger.getLogger(String.valueOf(StudentDaoTest.class));

    @Test
    public void testAddStudent() throws Exception {
        Student student=new Student();
        student.setName("我的");
        student.setQq(15465);
        student.setType("wo");
        student.setTime("jfkdjk");
        student.setGraduateInstitutions("sjdkj");
        student.setDailyLink("jdskfj");
        student.setVolunteer("fjkd");
        student.setCreateAt(132);
        student.setUpdateAt(45);

        int id=dao.add(student);
        logger.info("id="+id);


    }

    @Test
    public void tastUpdateStudent() throws Exception {
        Student student=new Student();
        student.setId(59);
        student.setName("看机会");
        student.setQq(15465);
        student.setType("wo");
        student.setTime("jfkdjk");
        student.setGraduateInstitutions("sjdkj");
        student.setDailyLink("jdskfj");
        student.setVolunteer("fjkd");
        student.setCreateAt(132);
        student.setUpdateAt(80);

       boolean i= dao.update(student);
       logger.info(""+i);

    }

    @Test
    public void testDeleteStudent() throws Exception{
       boolean i= dao.delete(42);
        logger.info(""+i);


    }

    @Test
    public void testGetStudent() throws Exception {
            Student student= dao.get(70);
        logger.info(""+student);

    }

    @Test
    public void testGetStudent1() throws Exception{
        List<Student> list=dao.get("九块九");
        logger.info(""+list);
    }



    @Test
    public void testFindAllStudent() throws Exception{
        List<Student> students=dao.findAll();
        for (Student student:students){
            logger.info(""+student);
        }
    }
}