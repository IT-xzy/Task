package org.wyq.task.tuscany;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.wyq.task.service.BaseService;

public class Service {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("config/tuscany/service.composite");
        node.start();
        System.out.println("server is ready");
        BaseService schoolService = node.getService(BaseService.class, "schoolServiceComponent");
        System.out.println(schoolService.selecSalarytAll());
    }
}
