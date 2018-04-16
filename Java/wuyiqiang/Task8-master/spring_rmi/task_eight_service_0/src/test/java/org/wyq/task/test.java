package org.wyq.task;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ContextConfiguration(locations = {"classpath:config/spring/applicationContext-dao.xml"})
public class test {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml");
    @Test
    public void text() {
        context.getBean("");
    }


}
