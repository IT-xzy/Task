package com.admincrud.dao;

import com.admincrud.pojo.Admin;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminDaoTest {
    private Logger logger =Logger.getLogger(AdminDaoTest.class);
    @Resource(name = "adminDao")
    private AdminDao adminDao;
    @Test
    public void findAdmins() {
        logger.info("findAdmins()：正在测试");
       List<Admin> admins =adminDao.findAdmins();
       for (Admin admin:admins){
           logger.info(admin);
       }
       logger.info("测试完成");
    }
    @Test
    public void findAdmin() {
        System.out.println(adminDao.findAdmin(1));
    }
    @Test
    public void saveAdmin() {
        logger.info("saveAdmin():正在测试");
        Admin admin =new Admin();
        admin.setAdminCode("1015320765");
        admin.setPassword("123456");
        admin.setName("tanghaiqing");
        admin.setTelephone("17688432366");
        admin.setEmail("1015320765@qq.com");
        admin.setEnrolldate(20180919L);
        logger.info(admin);
        adminDao.saveAdmin(admin);
    }
    @Test
    public void delAdmin() {
        logger.info("delAdmin()");
        adminDao.delAdmin(1);
        logger.info("执行完毕");
    }
    @Test
    public void delAdmins() {
        logger.info("delAdmins():开始测试");
        adminDao.delAdmins();
        logger.info("测试完成！");
    }
    @Test
    public void updateAdmin() {
        Admin admin =new Admin(1,"2105320765","123456","haiqing",
                "17688432366","1015320765@we.com",20180918L);
        adminDao.updateAdmin(admin);
    }
}