package com.fgh.Mybatis;


import com.fgh.Mybatis.Tool.TimeReversal;
import com.fgh.Mybatis.model.User;
import com.fgh.Mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Date;
import java.util.List;

//@RunWith 注释标签是 Junit 提供的，用来说明此测试类的运行者，
//        这里用了 SpringJUnit4ClassRunner，这个类是一个针对 Junit 运行环境的自定义扩展，
//        指定使用的单元测试执行类
//        用来标准化在 Spring 环境中 Junit4.5 的测试用例，例如支持的注释标签的标准化
//@ContextConfiguration 注释标签是 Spring test context 提供的，
//        用来指定 Spring 配置信息的来源，支持指定 XML 文件位置或者 Spring 配置类名，
    //        这里我们指定 classpath 下的 /config/Spring-db1.xml 为配置文件的位置
//@Autowired 体现了我们的测试类也是在 Spring 的容器中管理的，
//        他可以获取容器的 bean 的注入，您不用自己手工获取要测试的 bean 实例
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:applicationContext.xml"})
    public class UserServiceTest {
        @Autowired
        private  UserService userService;
        //private ApplicationContext applicationContext;
            @Before
       public void step()throws Exception{
//        applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        userService =(UserService)applicationContext.getBean("service");
}

   @Test
   public void testFinderUserBy()throws Exception{
       User user = new User();
       user.setUsername("安师傅1");
       user.setType("QA");
       List<User> users = userService.findUserBy(user);
       System.out.println(users);
    }


    @Test
    public void testInsertUser()throws Exception {
        User user = new User();
        user.setUsername("安师傅2");
        user.setQQ("201805121234");
        user.setType("QA");
        user.setDescription("插入数据2");
        user.setCreate_at(TimeReversal.Datetolong(new Date()));
        Boolean InsertBool=userService.insertUser(user);
        System.out.println(InsertBool);
        System.out.println(user.getId());


    }
    @Test
    public void testDelUser()throws Exception {
        Boolean DelBool=userService.delUser(4);
        System.out.println(DelBool);
    }
//
    @Test
    public void testUpdateUser()throws Exception {
        User user = new User();
        user.setId(2);
        user.setUsername("卡卡");
        user.setQQ("201805201126");
        user.setCounsellor("东方国际");
        user.setDescription("电饭锅");
        user.setUpdate_at(TimeReversal.Datetolong(new Date()));
        Boolean UpdateBool=userService.updateUser(user);
        System.out.println(UpdateBool);
    }

    @Test
    public void tesFindAll()throws Exception {
        List<User> users=userService.findAll();
        System.out.println(users);
    }


}
