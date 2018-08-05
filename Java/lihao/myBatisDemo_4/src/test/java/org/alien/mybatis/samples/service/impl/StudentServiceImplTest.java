package org.alien.mybatis.samples.service.impl;

import org.alien.mybatis.samples.model.Student;
import org.alien.mybatis.samples.service.StudentService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihoo
 * @Title: StudentServiceImplTest
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1214:46
 */


public class StudentServiceImplTest {
    private StudentService studentService;

    private static Logger logger = Logger.getLogger(AuthorServiceImplTest.class);

    @Before
    public void addProperties() {
        PropertyConfigurator.configure(
                "C:\\Users\\lihoo\\Documents\\back_item\\myBatisDemo_4\\src\\main\\resources\\log4j.properties");
    }


    @Before
    public void setUp() throws Exception {
        studentService = new StudentServiceImpl();
    }

    @Test
    public void testAddStudent() throws Exception {
        Assert.assertEquals(true,studentService.addStudent
                (new Student(100,"大梁",85296374,
                        "py工程师",528411501,"欧洲人大学",
                        "8856","https://www.odd4loah.cn","你把闪现赶紧给我交了",
                        "杀老师","这一手很强",15541661,
                        189856161)) > 0);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Assert.assertEquals(true,studentService.deleteStudent(21) > 0);
    }
//
    @Test
    public void testUpdateStudent() throws Exception {
        Assert.assertEquals(true,studentService.updateStudent
                (new Student(20,"皮一下",1999999999,
                "性感java工程师",5896247,"家里呆不下大学",
                "18856","1https://www.odd4loah.cn","鎏金哇卡一库咧",
                "星妈buff","狗啊你是",1577811661,
                8974512)) > 0);
    }

    @Test
    public void testGetStudentById() throws Exception {
        String sInfo = String.valueOf(studentService.getStudentById(8).getSchool()) ;
        logger.debug(sInfo);
    }


    @Test
    public void testGetStudentByName() throws Exception {
        String sInfo = String.valueOf(studentService.getStudentByName("李时珍的皮"));
            logger.debug(sInfo);
    }

    //end_Test
}
