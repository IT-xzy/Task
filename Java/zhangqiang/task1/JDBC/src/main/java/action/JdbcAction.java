package action;

import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.JdbcCurd;
import service.RandomStudent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAction {

    static Logger logger = Logger.getLogger(JdbcAction.class.getName());
    static JdbcCurd jdbcCurd = new JdbcCurd();
    RandomStudent randomStudent = new RandomStudent();
    Student student;

    public static void main() throws SQLException {

        jdbcCurd.selectById(22);
    }

    @Test
    public void selectTest() throws SQLException {

        logger.info(jdbcCurd.selectById(24));

        student = new Student();
        student.setName("福");
        logger.info(jdbcCurd.findByStudent(student));

    }

    @Test
    public void insertTest(){

        Student student = new RandomStudent().getStudent();

        logger.info(jdbcCurd.insert(student));
    }

    @Test
    public void insertListTest() throws SQLException {

        Student student;
        List<Student> students = new ArrayList<>();
        for(int i=0;i<5;i++){
            student = randomStudent.getStudent();
            students.add(student);
        }

        logger.info(jdbcCurd.insertList(students));
    }

    @Test
    public void updateTest() throws SQLException {
        student = randomStudent.getStudent();
        logger.info(jdbcCurd.update(student));
    }

    @Test
    public void updateListTest() throws SQLException {
        List<Student> students = new ArrayList<>();
        for (int i=50;i<55;i++){
            student = randomStudent.getStudent();
            student.setId(i);
            students.add(student);
        }
        logger.info(jdbcCurd.insertList(students));
    }

}
