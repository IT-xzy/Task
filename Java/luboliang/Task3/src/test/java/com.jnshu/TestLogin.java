package com.jnshu;

import com.jnshu.model.Login;
import com.jnshu.mapper.LoginDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestLogin {
    @Autowired
    LoginDao loginDao;
    Login login=new Login();

    @Test
    public void add(){
        login.setCreate_at(System.currentTimeMillis());
        login.setUpdate_at(System.currentTimeMillis());
        login.setEditor("超级管理员");
        login.setUser_name("你随意");
        login.setPassword("你随意");
        loginDao.addLogin(login);
        System.out.println("id======="+login.getId());

    }
    @Test
    public void delete(){
        System.out.println(loginDao.deleteLogin(100));

    }
    @Test
    public void update(){
        login.setUpdate_at(System.currentTimeMillis());
        login.setEditor("超级管理员");
        login.setUser_name("你随意");
        login.setPassword("你随意");
        login.setId(2);
        System.out.println(loginDao.updateLogin(login));


    }
    @Test
    public void findBy(){
        System.out.println(loginDao.findByLogin(1));

    }
    @Test
    public void findAll(){
        System.out.println(loginDao.findAllLogin());

    }

}
