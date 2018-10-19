package com.lihoo.jnshu;

import com.lihoo.jnshu.pojo.User;
import com.lihoo.jnshu.service.IBaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ClientTest
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IBaseService ibs = (IBaseService) context.getBean("baseService");
        System.out.println(ibs.getHelloWord("hao"));
        User user = new User();
        user.setName("chenghao");
        user.setAge(24);
        System.out.println(ibs.getUser(user));

    }
}
