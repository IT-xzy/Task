package com.leo.server;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * @Belong:
 * @Description:
 * @Author: jk-leo
 * @Date: 2018/10/3 15:24
 */
public class TuscanyServer {
	
	public static void main(String[] args){
		System.out.println("服务端将要启动");
		Node node = NodeFactory.newInstance().createNode("tuscany.composite");
		node.start();
		System.out.println("服务端已经启动");
	}
}
