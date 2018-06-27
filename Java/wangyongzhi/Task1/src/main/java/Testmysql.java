
import cc.myhome.model.Network1;
import cc.myhome.mybatis.service.NetworkService;
import cc.myhome.mybatis.service.NetworkServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static java.lang.System.out;

public class Testmysql {
    public static Logger logger = LogManager.getLogger(Testmysql.class);

    public static void main(String[] args) {
        logger.info("加载spring应用上下文：");
        ApplicationContext cx = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
        NetworkService networkservice = (NetworkServiceImpl) cx.getBean("networkServiceImpl");
        Network1 one = new Network1();
        Scanner console = new Scanner(System.in);
        long startTime;
        long endTime;
        long cost;
        while (true) {
            out.print("（1）循环插入数据  （2）根据姓名查询 ");
            switch (Integer.parseInt(console.nextLine())) {
                case 1:
                    one.setName("Jack");
                    one.setQQ("35135145");
                    one.setType("PM");
                    one.setEnrolmentTime("20181112");
                    one.setGraduate("东海大学");
                    one.setReportLink("www.dfgdxcvcbfgs.org");
                    one.setWish("实现自己");
                    one.setSenior("吴强");
                    one.setHowKnow("微信");
                    one.setCreateAt(201845526L);
                    one.setUpdateAt(201825225L);
                    startTime = System.currentTimeMillis();
                    try {

                        logger.info("插入数据开始：");
                        for (int i = 0; i < 10000L; i++) {
                            networkservice.insert(one);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                    logger.info("插入数据成功！");
                    endTime = System.currentTimeMillis();
                    cost = endTime - startTime;
                    logger.info("执行总用时" + cost + "ms");
                    break;

                case 2:

                    System.out.print("请输入想要查询的学生姓名：");
                    one.setLineId(null);
                    one.setName(console.nextLine());
                    startTime = System.currentTimeMillis();
                    one = networkservice.selectByIdName(one);
                    System.out.println(one.getLineId());
                    endTime = System.currentTimeMillis();
                    cost = endTime - startTime;
                    logger.info("执行总用时" + cost + "ms");
                    break;

            }
        }
    }
}
