package com.ptteng.rmi;

import com.ptteng.pojo.*;
import com.ptteng.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RmiServices {
    private static final Log LOGGER = LogFactory.getLog(RmiServices.class);

    @Autowired
    CategoryService categoryService ;

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();

        System.out.println("tuscany service启动");

    }





}
