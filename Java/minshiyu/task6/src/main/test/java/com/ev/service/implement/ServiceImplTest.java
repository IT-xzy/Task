package com.ev.service.implement;

import com.ev.entity.GoodOne;
import com.ev.entity.Occupation;
import com.ev.entity.User;
import com.ev.service.GoodOneService;
import com.ev.service.OccupationService;
import com.ev.service.StudentGeneralInfoService;
import com.ev.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ServiceImplTest {

    @Autowired
    GoodOneService goodOneService;

    @Autowired
    OccupationService occupationService;

    @Autowired
    StudentGeneralInfoService studentGeneralInfoService;

    @Autowired
    UserService userService;

    @Test
    public void testGoodOneService() throws Exception{
        GoodOne goodOneForTest=new GoodOne("test_name1","test_intro1", "test_path1", 123L, 123L);

//        System.out.println(goodOneService.addGoodOne(goodOneForTest));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>"+goodOneService.selectGoodOne());
    }

    @Test
    public void testOccupationService() throws Exception{
        Occupation occupationForTest=new Occupation("test_name1", "test_direction1", "test_des_det", "test_des_gen", 111, 222, "test_cycle", 333, "test_sal_fre", "test_sal_jun", "test_sal_sen", 444,"test_tips", 1L, 2L );

//        System.out.println(occupationService.addOccupation(occupationForTest));
        System.out.println(occupationService.selectOccupation());
    }

    @Test
    public void testStudentGeneralInfoService() throws Exception{
        System.out.println(studentGeneralInfoService.selectMainInfo());
    }

    @Test
    public void testUserService() throws Exception{
        User userForTest = new User("test_name", "test_key_value", "test_email", "test_phone_number", 1L, 2L, "test_salt");

//        System.out.println(userService.signUp(userForTest));
        System.out.println(userService.findUser("123"));
        System.out.println(userService.findUser("123@email.com"));
        System.out.println(userService.findUser("13111111111"));
        System.out.println(userService.login("123", "123"));

    }
}