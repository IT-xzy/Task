package cn.wyq.main;

import cn.wyq.service.OutstandingStudentService;
import cn.wyq.util.PageForMain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ClientTest {
    public static void main(String[] args)throws RemoteException,NotBoundException,MalformedURLException {
        OutstandingStudentService outstandingStudentService = (OutstandingStudentService)Naming.lookup("//localhost:8089/OutstandingStudentService");
        PageForMain page = new PageForMain();
        List msg = outstandingStudentService.get(page);
        System.out.println(msg);
    }
}
