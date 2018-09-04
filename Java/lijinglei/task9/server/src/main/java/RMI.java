
import com.jnshu.tools.Redis;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.util.Timer;
import java.util.TimerTask;


public class RMI {

    static String server = "ServerA";
    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode(server+".composite");

        try {
            node.start();
            System.out.println(server+" is Ready");
            timer1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serverLife() {
        Redis redis = new Redis();
        redis.setCacheObject(server,"running",500);
    }

    public static void timer1() {
        System.out.println(server+"运行");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
               serverLife();

            }
        }, 500,500);
    }
}