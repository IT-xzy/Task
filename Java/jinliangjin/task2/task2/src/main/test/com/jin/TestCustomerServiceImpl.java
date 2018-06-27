package com.jin;

import com.jin.Util.Log4JUtil;
import com.jin.dao.StudentServiceDao;
import com.jin.pojo.Student;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestCustomerServiceImpl {
    AbstractApplicationContext aac = null;
    StudentServiceDao customerServiceDao = null;
    private static Logger logger = Logger.getLogger(Object.class);
    @Before
    public void before(){
        aac = new ClassPathXmlApplicationContext("com/jin/spring/applicationContext-dao.xml");
        customerServiceDao = (StudentServiceDao) aac.getBean("studentService");
    }
    @Test
    public void insertCustomersTest(){
        customerServiceDao.insertStudents(2);
    }



    @Test
    public void selectStuTest(){
        Student student = new Student();
//        student.setId(1);
//        student.setName("万");
        System.out.println(customerServiceDao.selectStu(student))
        ;
    }
    @Test
    public void selectByNumberOrStringTest(){
        System.out.println(customerServiceDao.selectByNumberOrString(3));
    }


    @Test
    public void queryTest(){
        List<Student> students = customerServiceDao.query();
        for(Student student:students)
            logger.info(student);
    }

/*    @Test
    public void updateTest(){
        Student customer1 = new Student();
        customer1.setId(10);
        customer1.setName("曹越");
        Student customer2 = new Student();
        customer2.setId(11);
        customer2.setAddress("上海");
        List<Student> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customerService.update(customers);
    }*/
    @Test
    public void updateAddressTest(){
        customerServiceDao.updateKnowFromById("知乎",1,2,3);

    }

    @Test
    public void deleteByNumberTest(){
        customerServiceDao.deleteByNumber(6,7,13548547165L);
    }
}
