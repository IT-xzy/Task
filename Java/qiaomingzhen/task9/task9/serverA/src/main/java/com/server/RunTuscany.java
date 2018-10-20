package com.server;
/*
 * @ClassName:RunTuscany
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/15 14:58
 **/

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class RunTuscany {

    public static void main(String[] args) {
        Node node= NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("启动成功");
    }

}
