package com.jnshuboot.testTask;

import com.jnshuboot.DemobootApplication;
import com.jnshuboot.dao.LoginMapper;
import com.jnshuboot.pojo.*;
import com.jnshuboot.pojo.example.LoginExample;
import com.jnshuboot.service.LoginService;
import com.jnshuboot.util.Page;
import com.jnshuboot.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemobootApplication.class)
//@MapperScan(basePackages = "com.jnshuboot.dao")
public class TestLogin {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    LoginService loginService;
    @Autowired(required = false)
    LoginMapper loginMapper;

    @Test
    public void testLogin1() {
        Login login = new Login();
//        login.setLoginAccount("wuhkongg");
        login.setLoginPassword("123456");
//        login.setLoginMobile("19944404682");
        login.setLoginMail("aoccm@rr.cc");
        int i = loginService.register(login);
//        int i=loginMapper.insertSelective(login);
        Long j = login.getLoginId();
        log.warn("注册的账号数量为" + i);
        log.warn("注册的账号id为" + j);
        log.warn("注册的账号name为" + login);
    }

    @Test
    public void testLogin2() {
        Login login = new Login();
        login.setLoginId(1L);
        int i = loginService.delete(login.getLoginId());
        log.warn("删除的账号数量为" + i);
    }

    @Test
    public void testLogin3() {
        Login login = new Login();
        login.setLoginId(3L);
//        login.setLoginAccount("wukong");
        login.setLoginMobile("17744404682");
        login.setLoginMail("tuuuutt@qq.com");
        login.setLoginName("德玛西亚");
        int i = loginService.changInfo(login);
        log.warn("更新的账号数量为" + i);
    }

    @Test
    public void testLogin4() {
        Login login = new Login();
//        login.setLoginPassword("123456");
//        login.setLoginPassword("12345678");
        login.setLoginAccount(null);
//        login.setLoginMobile("19744404682");
//        login.setLoginMail("ttttt@qq.com");
//        login.setLoginName("testName3");
        int i = loginService.existAccount("wukonghaha");
        log.warn("验证账号的结果为" + i);
    }

    @Test
    public void testLogin5() {
        Login login = new Login();
        login.setLoginPassword("123456");
//        login.setLoginPassword("12345678");
//        login.setLoginAccount("wukonghaha");
//        login.setLoginMobile("16744404682");
        login.setLoginMail("zooouu@rr.cc");
//        login.setLoginName("testName3");
        boolean boo = loginService.logining(login);
        log.info("登录验证的结果为" + boo);
    }

    @Test
    public void testLogin6() {
        String mobile = "17744404682";
        String account = "wuhkongkk";
        String mail = "zooouu5@rr.cc";
        Login login = new Login();
        login.setLoginMobile(mobile);
        login.setLoginAccount(account);
        login.setLoginMail(mail);
        int j = loginService.existAccount(login.getLoginAccount());
        log.warn("通用账号验证的结果为" + j);
        int i = loginService.existMobile(login.getLoginMobile());
        log.warn("手机号验证的结果为" + i);
        int k = loginService.existMail(login.getLoginMail());
        log.warn("邮箱号验证的结果为" + k);
//        int j=loginService.existAccount(account);
//        log.warn("通用账号验证码的结果为"+j);
//        int i=loginService.existMobile(mobile);
//        log.warn("手机号验证码的结果为"+i);
    }

    @Autowired
    private LoginExample loginExample;

    @Test
    public void testLogin7() {
//        String mail="yuexiaopeng@jnshu.com";
//        String str=loginService.verifyMail(mail);
//        log.info("邮箱号验证码的结果为"+str);
//        String str=null;
//        log.info(str);
//        Login login=new Login();
//        LoginExample.Criteria criteria = loginExample.createCriteria();
//        criteria.andLoginMailEqualTo("17744404682");
//        List<Login> list=loginMapper.selectByExample(loginExample);
//        System.out.println(list);
        int i = loginService.existMobile("17744404682");
        System.out.println(i);
//        System.out.println(login);
    }

    @Test
    public void testLogin8() {
        String mobile = "19944404682";
        String account = "wuhkongk";
        String mail = "zooouu5@rr.cc";
        Login login = new Login();
        login.setLoginMobile(mobile);
        login.setLoginAccount(account);
        login.setLoginMail(mail);
        int i = loginService.existMobile(login.getLoginMobile());
        log.info("手机号2验证的结果为" + i);
        int j = loginService.existAccount(login.getLoginAccount());
        log.info("通用账号2验证的结果为" + j);
        int k = loginService.existMail(login.getLoginMail());
        log.warn("邮箱账号2验证的结果为" + k);
    }

    @Test
    public void loginPage() {
        List list = loginService.pageLogin(2, 5);
        log.warn("得到的分页login信息为" + list);
    }

    @Test
    public void pageTest() {
        LoginExample loginExample = new LoginExample();
        List list = loginMapper.selectByExample(loginExample);
        PageUtil pageUtil = new PageUtil();
        Page page = pageUtil.getPageInfo(100, 5, 80L);
        log.warn("得到的page信息为" + page);
    }
}
