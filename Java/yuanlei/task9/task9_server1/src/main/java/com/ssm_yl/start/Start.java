package com.ssm_yl.start;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main (String[] args){

        Node node = NodeFactory.newInstance().createNode(
                "categoryService.composite");
        node.start();
        System.out.println("service启动");
    }
}
