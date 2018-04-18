package com.run;

import com.service.Sca;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * @author Arike
 * Create_at 2018/2/8 14:16
 */
public class test {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("sca.composite");
        node.start();
        System.out.println("server is ready");
        Sca s = node.getService(Sca.class, "ScaImpl");
        System.out.println(s.idiom());
    }
}