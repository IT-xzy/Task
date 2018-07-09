package test;


import dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Student;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        StudentDaoImpl studentDaoImpl = (StudentDaoImpl) context.getBean ( "StudentDaoImpl" );
        //创建数据表 student_tb1
        System.out.println ( "------create tables--------" );
        studentDaoImpl.createTable ();
        //插入数据至数据表 student_tb1
        System.out.println ( "------insert data--------" );
        studentDaoImpl.insert ( "AA", 12 );
        studentDaoImpl.insert ( "BB", 20 );
        studentDaoImpl.insert ( "CC", 30 );
        //遍历有插入数据的相关信息
        System.out.println ( "------Listing Multiple Records--------" );
        List <Student> students = studentDaoImpl.listStudent ( );
        for (Student record : students) {
            System.out.print ( "ID:" + record.getId ( )+"  " );
            System.out.print ( "name:" + record.getName ( )+"  " );
            System.out.println ( "age:" + record.getAge ( )+"  ");
        }
        //更新ID=2的数据
        System.out.println ( "----Updating Record with ID = 2 -----" );
        studentDaoImpl.update ( 1, 10 );
        //查询ID=2的信息
        System.out.println ( "----Listing Record with ID = 2 -----" );
        Student student = studentDaoImpl.getStudent ( 2 );
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.println(", Age : " + student.getAge());
//    }
    }
}