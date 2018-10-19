package com.baidu.task8.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class Startup {
	private static final Log log = LogFactory.getLog(Startup.class);
	public static void main(String[] args) {
		Node node = NodeFactory.newInstance().createNode(
				"studentService.composite");
		node.start();
		log.info("开启了第二个服务...");
	}
}
