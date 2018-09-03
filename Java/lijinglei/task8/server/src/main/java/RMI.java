
import com.jnshu.service.ESService;
import com.jnshu.service.JIService;
import com.jnshu.service.SNService;
import com.jnshu.service.UserService;
import com.jnshu.service.impl.ESServiceImpl;
import com.jnshu.service.impl.JIServiceImpl;
import com.jnshu.service.impl.SNServiceImpl;
import com.jnshu.service.impl.UserServiceImpl;
import com.jnshu.tools.Redis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Timer;
import java.util.TimerTask;


public class RMI {
    public static void main(String[] args) {

//        System.setProperty("java.rmi.server.hostname","193.112.201.68");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");

        try {
            JIService jiService = new JIServiceImpl();
            SNService snService = new SNServiceImpl();
            UserService userService = new UserServiceImpl();
            ESService eSService = new ESServiceImpl();
            System.out.print("Ready");
            timer1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void serverLife() {
        Redis redis = new Redis();
        redis.setCacheObject("ServerB","running",500);
    }



    public static void timer1() {
        System.out.println("ServerB运行");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
               serverLife();

            }
        }, 500,500);
    }
}