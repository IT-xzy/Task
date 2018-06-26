package com.longhang;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;


public class MyMain{
    private static Logger logger= Logger.getLogger("MyMain.class");
        public static void main(String[] args){
            Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
            node.start();

            System.out.println("tuscany1 service启动");

        }
}
