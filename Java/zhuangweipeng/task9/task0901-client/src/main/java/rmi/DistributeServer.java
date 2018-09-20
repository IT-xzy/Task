package rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.PaperService;

@Component
public class DistributeServer {

    private static int random;

    public PaperService getPaperService() {
        PaperService paperService = null;
        random = getRandom();
        if (random == 0) {
            try {
                System.out.println("使用服务端A方法.......，随机数为：" + random + "\n\n");
                PaperService paperServiceA = getPaperServiceA();
                System.out.println("服务A已启动。。。\n");
                paperService = paperServiceA;
            } catch (Exception e) {
                System.out.println("服务端A宕机，切换使用服务端B方法.......，随机数为：" + random + "\n");
                PaperService paperServiceB = getPaperServiceB();
                System.out.println("服务B已启动。。。\n");
                paperService = paperServiceB;
            }
        }
        if (random == 1) {
            try {
                System.out.println("使用服务端B方法.......，随机数为：" + random + "\n");
                PaperService paperServiceB = getPaperServiceB();
                System.out.println("服务B已启动。。。\n");
                paperService = paperServiceB;
            } catch (Exception e) {
                System.out.println("服务端B宕机，切换使用服务端A方法.......，随机数为：" + random + "\n");
                PaperService paperServiceA = getPaperServiceA();
                System.out.println("服务A已启动。。。\n");
                paperService = paperServiceA;
            }

        }
        return paperService;
    }

    private int getRandom(){
        //产生一个大于等于0，小于2的随机数
        random = (int)(Math.random() * 2);
        System.out.println("\n\n"+random);
        return random;
    }

    private PaperService getPaperServiceA() {
        System.out.println("正在调用服务端A方法.......\n");
        ApplicationContext context =new ClassPathXmlApplicationContext("/spring/rmi-client.xml");

        PaperService p=  (PaperService) context.getBean("paperRMIServerA");
        System.out.println(p);
        return p;
    }
    private PaperService getPaperServiceB(){
        ApplicationContext context =new ClassPathXmlApplicationContext("/spring/rmi-client.xml");
        System.out.println("服务端B方法.......\n");
        return (PaperService) context.getBean("paperRMIServerB");
    }
}































 //
 //if (random == 1) {
 //        System.out.println("\n进入serverA中，random=" + random + "\n");
 //        try {
 //        return getPaperServiceA();
 //        }catch (Exception e){
 //        System.out.println("服务器A，8090端口异常，切换回服务器B，8091端口服务");
 //        return getPaperServiceB();
 //        }
 //        } else {
 //        System.out.println("\n进入serverB中，random=" + random + "\n");
 //        try{
 //        return getPaperServiceB();}
 //        catch (Exception e){
 //        System.out.println("服务器B，8091端口异常，切换回服务器A，8090端口服务");
 //        return getPaperServiceA();
 //        }
 //        }
