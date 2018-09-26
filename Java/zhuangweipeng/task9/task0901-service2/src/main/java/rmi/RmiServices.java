package rmi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.PaperService;

public class RmiServices {
    private static final Log LOGGER = LogFactory.getLog(RmiServices.class);

    @Autowired
    PaperService paperService ;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("tuscany service2启动");
    }
}
