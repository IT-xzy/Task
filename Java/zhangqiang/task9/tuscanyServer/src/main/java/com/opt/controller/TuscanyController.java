package com.opt.controller;

import com.opt.main.TusMain;
import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
public class TuscanyController {

    private static Logger logger = Logger.getLogger(TuscanyController.class);

    @RequestMapping("/o")
    public String open(){
        logger.info("main 启动tuscanyService服务");
//        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
//        System.setProperty("java.rmi.server.hostname", "47.98.50.21");
        System.setProperty("java.rmi.server.hostname", "119.29.17.188");
        Node node = NodeFactory.newInstance().createNode("tuscany/Computer.composite");
        node.start();
        try {
            while (true){TimeUnit.SECONDS.sleep(Long.MAX_VALUE);}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("发布tuscanyService服务成功！");
        return "serviceOpen";
    }


}
