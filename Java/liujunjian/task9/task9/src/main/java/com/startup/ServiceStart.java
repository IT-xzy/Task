package com.startup;

import com.service.TestService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class ServiceStart {
    public static void main(String[] args) {
        //创建Node工厂实例，通过工厂实例加载配置文件Calculator.composite
        Node node = NodeFactory.newInstance().createNode("sca.composite");
        //启动节点
        node.start();
        System.out.println("service启动");
    }
}
