package com.ptteng.rmi;

import com.ptteng.service.*;
import org.apache.commons.logging.*;
import org.apache.tuscany.sca.node.*;
import org.springframework.beans.factory.annotation.*;


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
