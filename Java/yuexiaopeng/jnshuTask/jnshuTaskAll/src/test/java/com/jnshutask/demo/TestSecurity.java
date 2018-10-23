package com.jnshutask.demo;

import com.jnshutask.BootTaskApplication;
import com.jnshutask.dao.TaRoleDao;
import com.jnshutask.pojo.TaLogin;
import com.jnshutask.pojo.TaRole;
import com.jnshutask.pojo.TaRoleMenu;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.security.TaSecurityProperties;
import com.jnshutask.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BootTaskApplication.class)
public class TestSecurity {
    @Autowired
    TaLoginService taLoginService;
    @Autowired
    TaStudentService taStudentService;
    @Autowired
    TaMenuService taMenuService;
    @Test
    public void test1() {
        List list=taMenuService.findUserMenus("mrBird");
        list.forEach(System.out::println);
    }
    @Test
    public void test2() {
        String str=taMenuService.findUserPermissions("mrBird");
        log.info(str);
    }
    @Autowired
    TaSecurityProperties taskSecurityProperties;
    @Test
    public void test3() {

        String str=taskSecurityProperties.getAnonResourcesUrl();
        log.info("字符串为:{}",str);
    }
    @Autowired
    TaRoleService taRoleService;
    @Autowired
    TaRoleDao taRoleDao;
    @Test
    public void test4() {
        TaRole taRole=new TaRole();
        taRole.setRoleName("user222");
        taRole.setDescription("user权限");
        taRole.setCreateTime(System.currentTimeMillis());
        TaRoleMenu taRoleMenu=new TaRoleMenu();
        taRoleMenu.setMenuId(13L);
        taRoleService.insertRole(taRole,taRoleMenu);
        taRoleDao.insertSelective(taRole);
    }
    @Test
    public void test5() {

        System.out.println(taRoleService.deleteRole(17L));

    }

}
