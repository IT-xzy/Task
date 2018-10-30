package server;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * Hello world!
 */
public class RmiServer {
    public static void main(String[] args) {
    //    //System.setProperty("java.rmi.server.hostname","139.199.127.53");
    //    //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rmiServer.xml");
    //    //StudentService studentService= (StudentService) applicationContext.getBean("studentService");
    //    //System.out.println(studentService.total());
    //   //Node node= (Node) NodeFactory.newInstance().createNode("server.composite");
    //   //node.start();
    //   // System.setProperty("java.rmi.server.hostname" , "127.0.0.1" );
        Node node=  NodeFactory.newInstance().createNode("server.composite");
        node.start();
        System.out.println("服务器端发布成功！");
    }

}
