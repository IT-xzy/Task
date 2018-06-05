package com.task1.service;


import com.task1.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * UserMapperService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 14, 2018</pre>
 */
public class UserMapperServiceTest {
    ApplicationContext applicationContext;

    //获得ioc容器
    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

//    根据id查询

    @Test
    public void testInsert()  {

        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        User user = new User("陈哲铭", "396154482", "JAVA", "2018年5月10日", "无", "java-257", "http://www.jnshu.com/daily/55619?dailyType=others&total=8&page=1&uid=23652&sort=0&orderBy=3",
                "既然选择来了，那就好好努力吧", "JAVA杨聪聪", "知乎");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userMapperService.insert(user);
//        测试事务管理
//        User user1 = new User();
//        user1.setName("事务管理");
//        userMapperService.insert(user1);
        System.out.print(user.getId());
    }

    //根据id删除
    @Test
    public void testDelete() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        System.out.print(userMapperService.delete(10));
    }

    //根据id更改
    @Test
    public void testUpdate() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        User user = new User();
        user.setId(7);
        user.setType("web");
        user.setOnlineNum("web-453");
        user.setElder("牛涛");
        user.setUpdateAt(System.currentTimeMillis());

        System.out.print(userMapperService.updateById(user));
    }

    //根据id查询
    @Test
    public void testSelectById() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        System.out.print(userMapperService.selectById(300));

    }

    //查询全表
    @Test
    public void testSelectAll() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        List<User> user = userMapperService.selectAll();
        for (User u : user) {
            System.out.println(u);
        }

    }

    //根据学号查询
    @Test
    public void testSelectByOnlineNum() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        List<User> user = userMapperService.selectByOnlineNum("java-257");
        for (User u : user) {
            System.out.println(u);

        }

    }

    //根据名字模糊查询
    @Test
    public void testSelectByName() {
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        List<User> user = userMapperService.selectByName("陈");
        for (User u : user) {
            System.out.println(u);
        }
    }

//        批量插入
    @Test
    public void testInsertBatch() {
long start=System.currentTimeMillis();
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = new User("陈哲铭", "396154482", "JAVA", "2018年5月10日", "无", "java-257", "http://www.jnshu.com/daily/55619?dailyType=others&total=8&page=1&uid=23652&sort=0&orderBy=3",
                    "既然选择来了，那就好好努力吧", "JAVA杨聪聪", "知乎");
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            list.add(user);
        }
        userMapperService.insertBatch(list);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}