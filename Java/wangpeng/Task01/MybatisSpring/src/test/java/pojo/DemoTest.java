/**
 * Author: 老王
 * Date: 2019/4/13 23:53
 */
package pojo;

import dao.DemoDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    private static ApplicationContext context;
    private static DemoDao deDao;

    @Test
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext1.xml");
        deDao = context.getBean(DemoDao.class);

        Demo de = deDao.queryDemoById(2);
        System.out.println(de);
    }

}