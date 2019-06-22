package cn.wp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName:
 * @Description:
 * @Author: WP
 * @Date: 2019/6/19 19:32
 * @Version: 1.0
 */
public class enter {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        System.out.println("服务2已启动!");
    }
}
