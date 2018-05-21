package jnshu.tasknine.main;

import jnshu.tasknine.util.SMRMISocket;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.server.RMISocketFactory;

/**
 * Created with IntelliJ IDEA.
 * WEB 的 服务端启动器
 * @author: Administrator
 * @date: 2017-11-10
 * @Time: 上午 10:02
 * Description:
 **/
public class RMIService {
//
//    @Autowired
//    static SMRMISocket smrmiSocket;
    static Object lock = new Object();

    private static Logger logRMIService = LoggerFactory.getLogger(RMIService.class);
    public static void main(String[] args) throws Exception{



        Node node = NodeFactory.newInstance().createNode("sca/Calculator.composite");
        RMISocketFactory.setSocketFactory(new SMRMISocket());
        node.start();
        logRMIService.info("初始化完成！ ");
        while(true){
            synchronized(lock){
                System.out.println( "2.无限期等待中..." );
                lock.wait(); //等待，直到其它线程调用 lock.notify()
            }
        }
    }
}