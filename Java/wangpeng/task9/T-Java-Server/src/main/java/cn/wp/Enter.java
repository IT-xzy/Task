package cn.wp;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/** 启动服务类 */
public class Enter {

  public static void main(String[] args) {

    Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
    node.start();
    System.out.println("服务已启动!");
  }
}
