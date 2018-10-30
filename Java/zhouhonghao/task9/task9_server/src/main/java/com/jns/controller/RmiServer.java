package com.jns.controller;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RmiServer {
    @RequestMapping("/tus")
    public String Tus(){
        System.setProperty("java.rmi.server.hostname","139.199.126.254");
        Node node=  NodeFactory.newInstance().createNode("server.composite");
        node.start();
        return "open";
    }
}
