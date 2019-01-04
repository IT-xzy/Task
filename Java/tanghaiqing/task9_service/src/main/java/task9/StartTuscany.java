package task9;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartTuscany {
    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode(
                "task9_tuscany.composite");
        node.start();
        System.out.println("service启动");
    }
}

