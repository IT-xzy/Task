
package com.dong.service;


import com.dong.model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
     @Autowired
    private StudentService studentService;
    Logger logger =Logger.getLogger(StudentServiceTest.class);


//    根据姓名查询
    @Test
    public void setStudentByStudentNameTest(){
        Student student =studentService.selectStudentByStudentName("何东霖");
        logger.debug("查找结果"+ student);
        System.out.println(student);
    }
//    根据id查询
//    @Test
//    public void selectStudenTest(){
//        Student student = studentService.selectStudent();
//        logger.debug("查找结果"+ student);
//        System.out.println(student);
//    }
//    根据学号查询
    @Test
    public void selectStudentByStudentIdTest(){
        Student student=studentService.selectStudentByStudentId(123);
        System.out.println(student);




        }
//    向表中添加数据
    @Test
    public void insertStudentTest(){
        Student student = new Student();
        student.setStudentEmail("leileilei@121231231");
        student.setStudentId(123);
        student.setStudentName("chang蕾雷");
        student.setStudentPassword("32135456");
        studentService.insertStudent(student);
        System.out.println(student+"\n"+"添加成功");
    }

//    通过id删除表中数据
    @Test
    public void deleteStudentById(){
         studentService.deleteStudentById(33);


    }


    //        修改表中数据
    @Test
    public void updateStudentTest(){
        Student student = new Student();
        student.setStudentEmail("基佬加微信@121231231");
        student.setStudentId(123);
        student.setStudentName("蕾雷");
        student.setStudentPassword("32135457");
        student.setId(35);
        studentService.updateStudent(student);

    }


//    查询整个表格







}

