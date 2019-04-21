/**
 * Author：老王
 * Time：2019/3/31 1:57
 **/

package cn.wp.action;

import cn.wp.entity.Contact;
import cn.wp.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class ContactAction {
    @Autowired
    private ContactService catService;

    @Test
    public void test1() {
        //获取上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        ContactService cat = context.getBean("contactService", ContactService.class);
        Contact c = cat.getContact(1);
        System.out.println(c);
    }
}
