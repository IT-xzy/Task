package com.jnshu.annotation.dao;

import com.jnshu.annotation.pojo.User;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void insert() {
        User user = new User();
        user.setName("tanghaiqing");
        user.setAge(21000);
        user.setGender("female");
        user.setSalary(0);
        System.out.println(userDao.insert(user));
    }

    @Test
    public void delect() {
        User user = new User();
        user.setId(21026);
        System.out.println(userDao.delect(user));
    }

    @Test
    public void updata() {
        User user = new User();
        user.setId(21010);
        user.setName("tanghaiqing");
        user.setAge(21);
        user.setGender("men");
        user.setSalary(-20000);
        System.out.println(userDao.updata(user
        ));
    }

    @Test
    public void getAll() {
        System.out.println( userDao.getAll());
    }
}