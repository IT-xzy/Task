package cn.wyq.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class ServiceStart {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Student.composite");
        node.start();
        System.out.println("服务已启动");
    }
}
