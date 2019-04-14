package com.ptteng;


import com.ptteng.service.ServiceImpl.StudentServiceImp;
import com.ptteng.service.StudentService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @ClassName Server
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/26  18:09
 * @Version 1.0
 **/
public class Server {

    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");

        node.start();
        System.out.println("启动服务成功");
    }
}
