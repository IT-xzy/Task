package com.admincrud.service;

import com.admincrud.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceImplTest {
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;

    @Test
    public void queryAllService() {
        List<Admin> admins=adminService.queryAllService();
        System.out.println(admins);
    }
    @Test
    public void queryAdminService() {
        Admin admin =adminService.queryAdminService(37);
        System.out.println(admin);
    }
    @Test
    public void saveAdminService() {
        Admin admin =new Admin();
        admin.setAdminCode("1015320765");
        admin.setPassword("123456");
        admin.setName("tanghaiqing");
        admin.setTelephone("17688432366");
        admin.setEmail("1015320765@qq.com");
        admin.setEnrolldate(20180919L);
        adminService.saveAdminService(admin);
    }
    @Test
    public void delAdminsService() {
        adminService.delAdminsService();
    }
    @Test
    public void delAdminService() {
        adminService.delAdminService(9);
    }
    @Test
    public void updateAdminService() {
        Admin admin =new Admin(6,"2105320765","123456","haiqing",
                "17688432366","1015320765@we.com",20180918L);
        adminService.updateAdminService(admin);
    }
}