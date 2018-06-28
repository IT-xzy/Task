package hzw.main;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class RmiService implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(RmiService.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
            //System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Node node = NodeFactory.newInstance().createNode("Calculator.composite");
            node.start();
            System.out.println("服务端RMI8888启动");
            logger.info("服务端RMI8888启动++++");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
