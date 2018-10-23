package com.example111.demo;

import com.jnshuboot.DemoApplication;
import com.jnshuboot.pojo.Login;
import com.jnshuboot.pojo.Student;
import com.jnshuboot.service.IUserService;

//import com.jnshuboot.service.UserInit;
import com.jnshuboot.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
    @Autowired
    ApplicationContext applicationContext;

    //    @Test
//    public void testRmi()  {
//        try{
//            IUserService iUserService=(IUserService)applicationContext.getBean("userService");
//
//            log.info("得到的类为{}",iUserService);
//            String str=iUserService.test("testLinux");
//            log.info("rmi简单测试的结果为:{}",str);
//        }catch(Exception e){
//            log.info("rmi调用错误");
//        }
//        List<Student> list=iUserService.getUser("yyu");
//        log.info("rmi查询的结果为:{}",list);
//        Student student=iUserService.selectById(43);
//        log.info("rmi查询的学生数据为:{}",student);
//        System.out.println(iUserService.test("kaka"));
//    }
    @Test
    public void testRmi2() {
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            try {
                log.info("首先使用rmi客户端1进行连接");
                IUserService iUserService = (IUserService) applicationContext.getBean("userService1");
                String str = iUserService.test("testLinux");
                log.info("使用rmi客户端1连接成功");
                log.info("rmi简单测试的结果为:{}", str);
            } catch (Exception e) {
                log.error("出错信息为{}", e.getMessage());
                log.info("开始使用rmi客户端2进行连接");
                IUserService iUserService = (IUserService) applicationContext.getBean("userService2");
                log.info("使用rmi客户端2连接成功");
                String str = iUserService.test("testLinux");
                log.info("rmi简单测试的结果为:{}", str);
            }
        } else {
            try {
                log.info("首先使用rmi客户端2进行连接");
                IUserService iUserService = (IUserService) applicationContext.getBean("userService2");
                log.info("使用rmi客户端2连接成功");
                String str = iUserService.test("testLinux");
                log.info("rmi简单测试的结果为:{}", str);
            } catch (Exception e) {
                log.error("出错信息为{}", e.getMessage());
                log.info("开始使用rmi客户端1进行连接");
                IUserService iUserService = (IUserService) applicationContext.getBean("userService1");
                log.info("使用rmi客户端1连接成功");
                String str = iUserService.test("testLinux");
                log.info("rmi简单测试的结果为:{}", str);
            }
        }
    }

    @Test
    public void testRmiLoign22() throws Exception {
        Random random = new Random();
        int i = random.nextInt(2);
        log.info("结果为{}", i);
//        System.out.println(iUserService.test("kaka"));
    }

    @Test
    public void testRmiUrl() {
        long lo = System.currentTimeMillis();
//        String urlString="rmi://59.110.143.57:1090/userService";
        String urlString = "http://59.110.143.57:8000";
//        String urlString="http://127.0.0.1";
        URL url;
        try {
            url = new URL(urlString);
            InputStream in = url.openStream();
            System.out.println("连接可用");
        } catch (Exception e1) {
            System.out.println("连接打不开!");
            url = null;
        }
//        System.out.println(iUserService.test("kaka"));
    }

}
