package action;

import dao.mapper.StudentMapper;
import model.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RandomStudent;

import java.util.ArrayList;
import java.util.List;

public class MainAction {

    static SpringMybatisAction sma = new SpringMybatisAction();
    static Student student = new RandomStudent().getStudent();

    public static void main(String[] args){

//        int id = 69;

//        student.setId(id);
//
//        System.out.print(sma.updateOne(student));

//        sma.chaxun();

        sma.selectOne(22);

    }

    @Test
    public void curdTest(){

        SpringMybatisAction sma = new SpringMybatisAction();
        List<Student> students = new ArrayList<>();
        RandomStudent randomStudent = new RandomStudent();
        student = randomStudent.getStudent();

        for(int i=0;i<10;i++){
            student = randomStudent.getStudent();
            students.add(student);
        }

        sma.insertForList(students);
//        sma.selectOne(33);
//        sma.updateOne(student);

    }

}
