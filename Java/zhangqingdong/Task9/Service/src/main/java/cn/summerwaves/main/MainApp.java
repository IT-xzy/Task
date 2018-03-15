package cn.summerwaves.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        node.start();
    }
}