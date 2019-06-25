/**
 * Author：老王
 * Time：2019/3/30 2:37
 **/

package pojo;

import dao.ContactDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactTest {
    private static ApplicationContext context;
    private static ContactDao catDao;

    static {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        catDao = context.getBean(ContactDao.class);
    }

    public static void main(String[] args) {
        //根据id查询信息
        long start = System.currentTimeMillis();//获取程序执行循环开始时间
        try {
            System.out.println("====================id查询单个信息====================");
            for (int i = 0; i < 1000; i++) {
                Contact cat;
                cat = catDao.queryContactById(2);
            }
//            System.out.println(cat);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序异常捕获");
        }
        long end = System.currentTimeMillis();//获取程序执行循环完毕时间
        System.out.println("使用连接池程序执行时间：" + (end - start) + "毫秒");//程序执行共耗时
    }
}


//    查
//    @Test
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        ContactDao catDao = (ContactDao) context.getBean("catDao");
//        Contact cat = catDao.queryContactById(1);
//        System.out.println(cat);
//    }

