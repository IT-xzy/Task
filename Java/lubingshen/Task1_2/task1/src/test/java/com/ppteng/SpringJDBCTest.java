package com.ppteng;

import com.ppteng.service.CrudService;
import com.ppteng.service.CrudServiceImpl;
import com.ppteng.utils.BeanReflect;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.ppteng.dao.StudentDAO;
import com.ppteng.bean.Student;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class SpringJDBCTest {

    @Autowired
    private StudentDAO studentDAO;


    @Test
    public void findByIdTest() throws Exception {
        Student student = studentDAO.findById(3L);
        System.out.println(student);
    }

    @Test
    public void findByNameTest() throws Exception {
        List<Student> students = studentDAO.findByName("曲");
        System.out.println(students);
    }

    @Test
    public void findByNumTest() throws Exception {
        Student student = studentDAO.findByNum("java-5");
        System.out.println(student);
    }

    @Test
    public void insertSingleTest() throws Exception {
        Logger logger = Logger.getLogger(SpringJDBCTest.class);
        Student student_insert = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-4",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        student_insert.setCreateAt(System.currentTimeMillis());
        logger.info(studentDAO.insertStudent(student_insert));
    }

    @Test
    public void insertStudentTest() throws Exception {
        Logger logger = Logger.getLogger(SpringJDBCTest.class);
        long start_insert = System.currentTimeMillis();
        Student student_insert = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        student_insert.setCreateAt(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            student_insert.setNum("java-" + i);
            logger.debug(studentDAO.insertStudent(student_insert) + "  :  " + student_insert.getId());
        }
        long end_insert = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_insert - start_insert) + "millisecond.");
    }

    @Test
    public void deleteStudentTest() throws Exception {
        System.out.println(studentDAO.deleteStudent(4L));
    }

    @Test
    public void updateStudentTest() throws Exception {
        Logger logger = Logger.getLogger(SpringJDBCTest.class);
        long start_update = System.currentTimeMillis();
        Student student_update = new Student();
        student_update.setUpdateAt(System.currentTimeMillis());
        student_update.setDeclaration("老大最帅");
        student_update.setId(1L);
        logger.info(studentDAO.updateStudent(student_update));
        long end_update = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end_update - start_update) + "millisecond.");
    }

/*    @Test
    public void updateAllTest() throws Exception {
        Logger logger = Logger.getLogger(SpringJDBCTest.class);
        long start = System.currentTimeMillis();
        Student student = new Student();
        student.setUpdateAt(System.currentTimeMillis());
        student.setDeclaration("老大最帅");
        logger.debug(studentDAO.updateStudent(student));
        long end = System.currentTimeMillis();
        logger.info("The total time spent on updating is " + (end - start) + "millisecond.");
    }*/

    @Test
    public void truncateTableTest() throws Exception {
        studentDAO.truncateTable();
    }

    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(simpleDateFormat.format(1000L));
    }

    @Test
    public void test2() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("uhgfhh");
        arrayList.add("2");
        // 正确转化方式
        Object[] things = arrayList.toArray();
        for (Object object : things) {
            System.out.println(object);
        }
        // 错误的转化方式
        // String[] strArray = (String[]) arrayList.toArray();
    }

    @Test
    public void test3() {
        try {
            CrudService service = new CrudServiceImpl();
            Long selectID = 3L;
            Student studentByID;
            studentByID = service.findByPrimeKey(selectID);
            if (studentByID != null)
                System.out.println(("->成功找到ID为“" + selectID + "”的学员：\n" + studentByID));
            else
                System.out.println(("->查询失败，ID为" + selectID + "的学员不存在！"));
        } catch (RuntimeException e) {
            System.out.println("->警告;" + e.getMessage());
        } catch (Exception e1) {
            System.out.println("->查询的时候发生错误！");
        }
    }

    @Test
    public void test5() {
        Field[] fields = Student.class.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            System.out.println(name);
            String type = field.getGenericType().toString(); // 获取属性的类型
            System.out.println(type);
        }
        System.out.println("*************************");
    }

    @Test
    public void reflectTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Student student = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-4",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        System.out.println(BeanReflect.reflect(student));
    }
}
