package com.jnshutask.demo;

import com.jnshutask.BootTaskApplication;
import com.jnshutask.controller.ControllerUtil.UserNameUtil;
import com.jnshutask.controller.TestController;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.pojo.TaUser;
import com.jnshutask.service.*;
import com.jnshutask.service.imp.TaMenuServiceImp;
import com.jnshutask.service.imp.TaUserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BootTaskApplication.class)
public class TestV {
    @Autowired
    TaLoginService taLoginService;
    @Autowired
    TaStudentService taStudentService;
    @Test
    public void test1() {
        TaStudent taStudent=new TaStudent();
        TestValition testValition=new TestValition();
        testValition.test222(taStudent);
    }
    @Test
    public void test2() {

        TaUser o=new TaUser();

        ArrayList arrayList=new ArrayList();
        arrayList.add(0,"haha");
        arrayList.forEach(System.out::println);
        System.out.println("**************");
        arrayList.add(0,"hehe");
        arrayList.forEach(System.out::println);

    }
    @Test
    public void test4() throws Exception{
        UserNameUtil.GetName hah= new UserNameUtil.GetName("ahah");
//        hah.getName();
        TaUser taUser=TaUser.class.newInstance();
        log.info("{}",taUser);
    }
    @Autowired
    private TaUserService userService;

    @Autowired
    private TaMenuService menuService;
    @Test
    public void test5() throws Exception{
        TaUser taUser=userService.selectUserByUsername("admin");
        System.out.println(taUser);
//        System.out.println(new TaMenuServiceImp().findUserPermissions(taUser.getUsername()));
        System.out.println(menuService.findUserPermissions(taUser.getUsername()));

    }

}
