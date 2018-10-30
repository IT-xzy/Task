package com.jnshu;

import mybatis.Mapper;
import mybatis.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private Mapper userMapper;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setName("雷锋");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(12345678);
        user.setCourse_type("web");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(678678);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("变胖两斤");
        user.setBrother("鲁伯良");
        user.setLearn("朋友推荐");
//        直接执行方法传参
        userMapper.addUser(user);
        System.out.println("用户Id===" + user.getId());
    }
    @Test
    public void deleteTest(){
        System.out.println(userMapper.deleteUser(7));
    }
    @Test
    public void updateUserTest(){
        User user=new User();
        user.setName("雷锋");
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(12345678);
        user.setCourse_type("web");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(678678);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("变胖两斤");
        user.setBrother("鲁伯良");
        user.setLearn("朋友推荐");
        user.setId(34);

        System.out.println(userMapper.updateUser(user));
    }
    @Test
    public void findUserById(){
        System.out.println(userMapper.findUser(34));
    }
    @Test
    public void findAll(){
        System.out.println(userMapper.findAll());
    }
}
