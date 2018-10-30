package com.jnshu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springTest.User;
import springTest.UserImpl;

/**
 * Unit test for simple App.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class AppTest {

    /**
     * Rigorous Test :-)
     */
    User user = new User();
    @Autowired
    UserImpl u;

    @Test
    public void testAdd() {
        User user = new User();
        user.setId(2);
        user.setName("金石开");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(1050376715);
        user.setCourse_type("产品经理");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(4487);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("变胖两斤");
        user.setBrother("李天宇");
        user.setLearn("朋友推荐");

        System.out.println(u.add(user));

    }

    @Test
    public void testDelete() {

        System.out.println(u.delete(25));
    }

    @Test
    public void testUpdate() {
        user.setId(2);
        user.setName("金石开");
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(1050376715);
        user.setCourse_type("产品经理");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(4487);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("变胖两斤");
        user.setBrother("李天宇");
        user.setLearn("朋友推荐");
        System.out.println(u.update(user));
    }

    @Test
    public void testSelect() {

        System.out.println(u.select(25));


    }

    @Test
    public void testFindUser() {

        System.out.println(u.findUser());
    }

}
