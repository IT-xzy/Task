package lujing.controller;


import lujing.service.ScaDemo;
import org.apache.tuscany.sca.TuscanyRuntime;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.oasisopen.sca.NoSuchServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lujing
 * Create_at 2018/1/29 14:25
 */
public class TuscanyRun {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-tuscany.xml");
        Node node = NodeFactory.newInstance().createNode("Sac1.composite");
        node.start();
        System.out.println("service启动");
    }
}
