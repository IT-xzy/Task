package org.wyq.task;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.junit.Test;
import org.wyq.task.service.BaseService;

//@ContextConfiguration(locations = {"classpath:config/spring/applicationContext-dao.xml"})
public class test {
    @Test
    public void Service(){
        Node node = NodeFactory.newInstance().createNode("config/tuscany/service.composite");
        node.start();
        System.out.println("server is ready");
        BaseService s = node.getService(BaseService.class, "schoolService");
        System.out.println(s.selecSalarytAll());
    }


}
