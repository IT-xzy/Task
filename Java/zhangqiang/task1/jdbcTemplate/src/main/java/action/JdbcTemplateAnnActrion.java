package action;


import dao.impl.StudentDaoImpl;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.RandomStudent;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationcontext.xml"})
public class JdbcTemplateAnnActrion {

    private Logger logger = Logger.getLogger(JdbcTemplateAnnActrion.class.getName());
    private RandomStudent randomStudent = new RandomStudent();

    @Autowired
    @Qualifier("studentDaoImpl")
    private StudentDaoImpl studentDaoImpl;

    @Test
    public void testAnnotationTest(){

        logger.info(studentDaoImpl.selectById(44));

    }

    @Test
    public void insertTest(){

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        for (int i=0;i<5;i++){
            student = randomStudent.getStudent();
            student.setId(i+5);
            System.out.print("第" + (i+5) + "条数据修改前：\n"+studentDaoImpl.selectById(i+5));
            students.add(student);
        }

//        logger.info(studentDaoImpl.insertLiset(students));
        int[] a = studentDaoImpl.updateList(students);
        System.out.print(a.length);

    }


}
