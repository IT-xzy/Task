package cn.wyq.listener;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TuscanyListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(TuscanyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("启动Service服务");
        System.setProperty("java.rmi.server.hostname","47.104.225.105");
        Node node = NodeFactory.newInstance().createNode("Student.composite");
        node.start();
        logger.info("启动服务成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
