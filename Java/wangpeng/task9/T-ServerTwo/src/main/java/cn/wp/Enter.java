package cn.wp;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 启动服务类 */
public class Enter implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
    node.start();
    System.out.println("服务2已启动!");
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
