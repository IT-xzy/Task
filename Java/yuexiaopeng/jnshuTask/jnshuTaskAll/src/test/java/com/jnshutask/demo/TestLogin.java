package com.jnshutask.demo;

import com.jnshutask.BootTaskApplication;
import com.jnshutask.pojo.TaLogin;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.service.TaLoginService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BootTaskApplication.class)
public class TestLogin {
    @Autowired
    TaLoginService taLoginService;
    @Test
    public void login1() {
        TaLogin taLogin=new TaLogin();
        List<TaLogin> logins=taLoginService.pageLogin(3,3);
        logins.forEach(System.out::println);
    }
    @Test
    public void login2() {
        TaLogin taLogin=new TaLogin();
        List<TaLogin> logins=taLoginService.pageLogin(1,8);
        logins.forEach(System.out::println);
    }
    @Test
    public void login3() {
        TaLogin taLogin=new TaLogin();
        List<TaLogin> logins=taLoginService.pageLogin(2,8);
        logins.forEach(System.out::println);
    }

}
