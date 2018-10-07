package com.server;
/*
 * @ClassName:RunTuscany
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/15 14:58
 **/

import com.model.People;
import com.service.UserService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunTuscany {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Node node= NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("启动成功");
        UserService userService = (UserService) Naming.lookup("rmi://127.0.0.1:1114/userService");

//        UserService userService=node.getService(UserService.class,"userService");
        System.out.println( userService.selectById(1L));
    }

}
