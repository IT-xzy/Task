package com.baidu.task8.server;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.junit.Test;

/**
 * @author huangdongjiang
 * @date 2018/8/16 21:34
 */
public class test {
	@Test
	public void test() {
		Node node = NodeFactory.newInstance().createNode(
				"studentService.composite");
		node.start();
		System.out.println("成功开启。");
	}
}
