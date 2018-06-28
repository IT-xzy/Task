package com.unit;

import com.dao.Dao;
import com.entity.Person;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text007 {
    private ApplicationContext applicationContext;
    private UserService userService;

    @Before
    public void set() {
        applicationContext = new ClassPathXmlApplicationContext(new String("classpath:applicationContext.xml"));
        userService = (UserService) applicationContext.getBean("ServiceI");
    }

    @Test
    public void addUser() throws Exception{
        Person stu = new Person();
        stu.setId(13);
        stu.setName("李会强");
        stu.setQQ("582226014");
        stu.setIesson_type("JAVA工程师");
        stu.setEnroiment_time("2017-09-15 13:14:15");
        stu.setGraduated_school("哈尔滨工程大学");
        stu.setStudent_ID(2327);
        stu.setDaily_conection("http://www.jnshu.com/daily/33298?dailyType=others&total=7&page=2&uid=16212&sort=0&orderBy=3");
        stu.setWish("人生第二次关键选择，我自己来决定！");
        stu.setBrother_name("宋哲明");
        stu.setChannel("知乎");

        userService.addUser(stu);
        System.out.println(stu.getId());
    }

    @Test
    public void updateUser() throws Exception{
        Person stu =new Person();
        stu.setId(15);
        stu.setName("武松");
        stu.setQQ("3849213213");
        stu.setIesson_type("QA工程师");
        stu.setEnroiment_time("2018-04-05 13:14:15");
        stu.setGraduated_school("无");
        stu.setStudent_ID(3346);
        stu.setDaily_conection("http://www.jnshu.com/daily/55730?dailyType=others&total=14&page=1&uid=22245&sort=0&orderBy=3");
        stu.setWish("三十年河东，三十年河西，莫欺少年穷");
        stu.setBrother_name("常雷雷");
        stu.setChannel("知乎");

        System.out.println(userService.updateUser(stu));
    }

    @Test
    public void deleteUser() throws Exception{
        System.out.println(userService.deleteUser(16));
    }

    @Test
    public void queryName() throws Exception{
        Person person = userService.queryName("风波恶");
        System.out.println(person);
    }

    @Test
    public  void queryId() throws Exception{
            Person person = userService.queryId(6);
            System.out.println(person);
    }
}