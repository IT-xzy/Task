package com.xiuzhenyuan.task1.dao;

import com.xiuzhenyuan.task1.tool.PrintFormat;
import com.xiuzhenyuan.task1.model.StudentDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest extends BaseJunit {
    ApplicationContext act=  new ClassPathXmlApplicationContext("SpringConfig.xml");
    StudentDAO studentDAO= (StudentDAO)act.getBean("studentDAO");

    @Autowired
    PrintFormat printFormat;
    @Before

    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void saveStudent() {
        for (int i=0;i<1;i++) {
            long t=System.currentTimeMillis();
            StudentDO studentDO = new StudentDO();
            studentDO.setName("孙虎");
            studentDO.setQq(1586974154);
            studentDO.setDailyLink("ahduad5561");
            studentDO.setEntorTime(20180413);
            studentDO.setGraduateSchool("中南大学");
            studentDO.setNetId(3699);
            studentDO.setSenior("旺旺");
            studentDO.setType("pm");
            studentDO.setWish("胜天");
            studentDO.setCreateTime(t);
            studentDAO.saveStudent(studentDO);
            System.out.println(studentDO.getAddId());
        }
    }
    @Test
    public void updateStudent(){
        long t=System.currentTimeMillis();
       StudentDO studentDO=new StudentDO(1,"pm",t);
        Boolean a =studentDAO.updateStudent(studentDO);
        System.out.println(a);
    }


    @Test
    public void selectLikeNameNetId() {
        StudentDO studentDO= new StudentDO();
//        studentDO.setName("宇");
        studentDO.setNetId(25);
        List<StudentDO> stu=studentDAO.selectLikeNameNetId(studentDO);
        for (StudentDO studentDO2:stu)
            printFormat.printf(studentDO2);
    }

    @Test
    public void deleteStudentByAdd_id() {
        boolean a=studentDAO.deleteStudentByAddId(150);
        System.out.println(a);
    }

    @Test
    public void getStudent() {
        StudentDO studentDO=studentDAO.getStudent(165);
        System.out.println(studentDO.getAddId());
    }

    @Test
    public void studentBatchInsert() {
        List<StudentDO> stu =new ArrayList<StudentDO>();
        StudentDO studentDO1 =new StudentDO("孙虎3", 1586974154, "pm", 20180413, "中南大学",
                3699, "ahduad5561", "胜天", "旺旺", System.currentTimeMillis());
        StudentDO studentDO2 =new StudentDO("孙虎4", 1586974154, "pm", 20180413, "中南大学",
                3699, "ahduad5561", "胜天", "旺旺", System.currentTimeMillis());
        stu.add(studentDO1);
        stu.add(studentDO2);
        System.out.println(studentDAO.studentBatchInsert(stu));

    }
}
